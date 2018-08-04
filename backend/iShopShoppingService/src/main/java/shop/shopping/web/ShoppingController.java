package shop.shopping.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.shopping.domain.Product;
import shop.shopping.domain.ShoppingCart;
import shop.shopping.service.ShoppingCartDTO;
import shop.shopping.service.ShoppingService;

@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping(value = "/addToCart/{cartId}/{productNumber}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId, @PathVariable String productNumber, @PathVariable int quantity) {
		shoppingService.addToCart(cartId, productNumber, quantity);
		return new ResponseEntity<ShoppingCartDTO>(HttpStatus.OK);		
	}
	
	@GetMapping("/getCart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		ShoppingCartDTO cart = shoppingService.getCart(cartId);
		return new ResponseEntity<ShoppingCartDTO>(cart, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cart/checkout/{cartId}")
	public ResponseEntity<?> checkoutCart(@PathVariable String cartId) {
		shoppingService.checkout(cartId);
		return new ResponseEntity<ShoppingCartDTO>(HttpStatus.OK);		
	}
	
}
