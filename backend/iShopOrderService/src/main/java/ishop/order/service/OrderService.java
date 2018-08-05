package ishop.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ishop.order.domain.Order;
import ishop.order.dto.CustomerDto;
import ishop.order.dto.ShoppingCartDto;
import ishop.order.integration.CustomerProxy;
import ishop.order.integration.EmailSender;
import ishop.order.integration.Logger;
import ishop.order.payload.ApiResponse;
import ishop.order.repository.OrderRepository;
import ishop.security.UserPrincipal;



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
	public ResponseEntity<?> getOrder(Optional<String> orderNumber, UserPrincipal currentUser) {
		
		if (!orderNumber.isPresent()) {
			return new ResponseEntity<List<Order>>(orderRepository.findAll(), HttpStatus.OK);
		}
		
		Optional<Order> optOrder = orderRepository.findById(orderNumber.get());
		if (optOrder.isPresent()) {

			Order order = optOrder.get();
			if (order.getCustomer().getCustomerId().longValue() ==  currentUser.getId().longValue()) {
				return new ResponseEntity<Order>(order, HttpStatus.OK);
			} else {
				return new ResponseEntity(new ApiResponse(false, "Specified order belongs to other user!"),
						HttpStatus.UNAUTHORIZED);	
			}

		} else
			return new ResponseEntity(new ApiResponse(false, "Specified order is not available!"),
					HttpStatus.BAD_REQUEST);	
	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> createOrder(ShoppingCartDto shoppingCartDto, UserPrincipal currentUser) {	
		CustomerDto customerDto = customerProxy.getOrderCustomer(currentUser.getId());
		if(customerDto != null) {
			Order order = OrderFactory.createOrder(shoppingCartDto, customerDto);
			Order result = orderRepository.save(order);
			return new ResponseEntity<Order>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity(new ApiResponse(false, "Specified order customer is not available!"),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	/*
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
			OrderCustomerDto customerDTO = customerProxy.getOrderCustomer(customerNumber);
			if(customerDTO!=null) {
				order.setCustomer(OrderCustomerAdapter.getCustomer(customerDTO));
			}
			orderRepository.save(order);
		}		
	}
*/
}
