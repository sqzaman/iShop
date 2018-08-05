package ishop.order.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ishop.order.dto.ShoppingCartDto;
import ishop.order.service.OrderService;
import ishop.security.CurrentUser;
import ishop.security.UserPrincipal;


@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@GetMapping({"/get/{orderId}", "/get"})
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> getCart(@PathVariable Optional<String> orderId, @CurrentUser UserPrincipal currentUser) {
		return orderService.getOrder(orderId, currentUser);
	}
	
	
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> createOrder(@RequestBody ShoppingCartDto shoppingCartDto, @CurrentUser UserPrincipal currentUser) {	
		return orderService.createOrder(shoppingCartDto, currentUser);
	}
	
	/*
	@PostMapping("/confirm/{orderNumber}")
	@PreAuthorize("hasRole('CUSTOMER')")
	public void confirm(@PathVariable String orderNumber) {
		orderService.confirm(orderNumber);
	}
	

	@PostMapping("/setCustomer/{orderNumber}/{customerNumber}")
	public ResponseEntity<?> SetCustomer(@PathVariable String orderNumber,@PathVariable String customerNumber) {
		orderService.setCustomer(orderNumber,customerNumber);
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
*/
	
}
