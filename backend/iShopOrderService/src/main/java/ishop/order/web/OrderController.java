package ishop.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ishop.order.domain.Order;
import ishop.order.domain.OrderFactory;
import ishop.order.dto.ShoppingCartDto;
import ishop.order.service.OrderDTO;
import ishop.order.service.OrderService;
import ishop.order.service.ShoppingCartDTO;


@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<?> getCart(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody ShoppingCartDto shoppingCartDto) {	
		return orderService.createOrder(shoppingCartDto);
	}
	
	@PostMapping("/confirm/{orderNumber}")
	public void confirm(@PathVariable String orderNumber) {
		orderService.confirm(orderNumber);
	}
	
	@PostMapping("/setCustomer/{orderNumber}/{customerNumber}")
	public ResponseEntity<?> SetCustomer(@PathVariable String orderNumber,@PathVariable String customerNumber) {
		orderService.setCustomer(orderNumber,customerNumber);
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}

	
}
