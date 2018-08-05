package ishop.shopping.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ishop.security.CurrentUser;
import ishop.security.UserPrincipal;
import ishop.shopping.domain.Product;
import ishop.shopping.domain.ShoppingCart;
import ishop.shopping.dto.ShoppingCartDto;
import ishop.shopping.payload.ShoppingRequest;
import ishop.shopping.service.ShoppingService;

@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping(value = "/addToCart")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> addToCart(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody ShoppingRequest shoppingRequest) {
		return shoppingService.addToCart(shoppingRequest, currentUser);
	
	}
	
	@GetMapping("/getCart/{cartId}")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> getCart(@PathVariable String cartId, @CurrentUser UserPrincipal currentUser) {
		return shoppingService.getCart(cartId);
	}
	
	@PostMapping(value = "/cart/checkout/{cartId}")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> checkoutCart(@CurrentUser UserPrincipal currentUser, @PathVariable String cartId) {
		shoppingService.checkout(cartId);
		return new ResponseEntity<ShoppingCartDto>(HttpStatus.OK);		
	}
	
}
