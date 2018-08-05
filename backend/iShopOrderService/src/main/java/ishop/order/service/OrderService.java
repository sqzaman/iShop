package ishop.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ishop.order.domain.Order;
import ishop.order.domain.OrderConfirmedEvent;
import ishop.order.domain.OrderLine;
import ishop.order.domain.ProductSoldEvent;
import ishop.order.dto.ShoppingCartDto;
import ishop.order.integration.CustomerProxy;
import ishop.order.integration.EmailSender;
import ishop.order.integration.Logger;
import ishop.order.payload.ApiResponse;
import ishop.order.repository.OrderRepository;



@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerProxy customerProxy;
	@Autowired
	EmailSender emailSender;
	@Autowired
	Logger logger;
	@Autowired
	private ApplicationEventPublisher publisher;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getOrder(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			return new ResponseEntity<Order>(optOrder.get(), HttpStatus.OK);
		} else
			return new ResponseEntity(new ApiResponse(false, "Specified order is not available!"),
					HttpStatus.BAD_REQUEST);	
	
	}
	
	public ResponseEntity<?> createOrder(ShoppingCartDto shoppingCartDto) {	
		Order order = OrderFactory.createOrder(shoppingCartDto);
		Order result = orderRepository.save(order);
		return new ResponseEntity<Order>(result, HttpStatus.OK);
	}
	
	public void confirm(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order= optOrder.get();
			order.confirm();
			emailSender.sendEmail("Thank you for your order with order number "+order.getOrdernumber(), "customer@gmail.com");
			logger.log("new order with order number "+order.getOrdernumber());
			//publish event
			OrderConfirmedEvent event = new OrderConfirmedEvent(OrderAdapter.getOrderDTO(order));
			publisher.publishEvent(event);
			//publish event for each product
			for (OrderLine orderline : order.getOrderlineList()) {
				ProductSoldEvent productSoldEvent = new ProductSoldEvent(orderline.getProduct().getProductnumber(), orderline.getQuantity());
				publisher.publishEvent(productSoldEvent);
			}
		} 
	}

	public void setCustomer(String orderNumber, String customerNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			OrderCustomerDTO customerDTO = customerProxy.getOrderCustomer(customerNumber);
			if(customerDTO!=null) {
				order.setCustomer(OrderCustomerAdapter.getCustomer(customerDTO));
			}
			orderRepository.save(order);
		}		
	}

}
