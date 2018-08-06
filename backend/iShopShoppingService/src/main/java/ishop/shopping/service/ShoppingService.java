package ishop.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ishop.security.UserPrincipal;
import ishop.shopping.adapter.ShoppingCartAdapter;
import ishop.shopping.domain.Product;
import ishop.shopping.domain.ShoppingCart;
import ishop.shopping.dto.ProductDto;
import ishop.shopping.integration.OrderProxy;
import ishop.shopping.integration.ProductCatalogProxy;
import ishop.shopping.payload.ApiResponse;
import ishop.shopping.payload.ShoppingRequest;
import ishop.shopping.repository.ShoppingCartRepository;
import ishop.util.Helper;

@Service
public class ShoppingService {
	@Autowired
	ProductCatalogProxy productCatalogProxy;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	OrderProxy orderProxy;
	
	/*
	@Autowired
	private ApplicationEventPublisher publisher;
*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?>  addToCart(ShoppingRequest shoppingRequest, UserPrincipal currentUser) {
		ShoppingCart result = null;
		ProductDto productsProduct = productCatalogProxy.getProduct(shoppingRequest.getProductId());
		//create a shopping product from a products product
		Product product = new Product(productsProduct.getProductId(), productsProduct.getName(), productsProduct.getDescription(), productsProduct.getPrice());
		if(shoppingRequest.getCartId() == null || shoppingRequest.getCartId().isEmpty()) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartId(Helper.getInstance().generateRandomString());
			cart.addToCart(product, shoppingRequest.getQuantity());
			cart.setCustomerId(currentUser.getId());
			result = shoppingCartRepository.save(cart);
		} else {
			
			Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(shoppingRequest.getCartId() );
			if (cartOptional.isPresent()) {
			
				ShoppingCart cart = cartOptional.get();
				if(cart.getCustomerId().longValue() != currentUser.getId().longValue()) {
					return new ResponseEntity(
							new ApiResponse(false, "Your are not allowed to add product to this cart!"),	HttpStatus.UNAUTHORIZED);
				}

				cart.addToCart(product, shoppingRequest.getQuantity());
				result = shoppingCartRepository.save(cart);
			}
		}
		
		return new ResponseEntity<ShoppingCart>(result, HttpStatus.OK); 
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
			return new ResponseEntity<ShoppingCart>(cart.get(), HttpStatus.OK);
		else
			return new ResponseEntity(new ApiResponse(false, "Specified category is not available!"),
					HttpStatus.BAD_REQUEST);		
		
	}
	
	


	public void checkout(String cartId, HttpHeaders headers) {
		Optional<ShoppingCart> cartOpt = shoppingCartRepository.findById(cartId);
		if (cartOpt.isPresent()) {
			ShoppingCart cart = cartOpt.get();
			//publish event
			//ShoppingCartCheckedOutEvent event = new ShoppingCartCheckedOutEvent(cart);
			//publisher.publishEvent(event);
			
			orderProxy.createOrder(ShoppingCartAdapter.getShoppingCartDto(cart), headers);
		}		
	}
	
}
