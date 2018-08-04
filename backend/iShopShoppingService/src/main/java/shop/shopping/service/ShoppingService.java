package shop.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import shop.shopping.domain.Product;
import shop.shopping.domain.ShoppingCart;
import shop.shopping.domain.ShoppingCartCheckedOutEvent;
import shop.shopping.integration.OrderProxy;
import shop.shopping.integration.ProductCatalogProxy;
import shop.shopping.repository.ShoppingCartRepository;

@Service
public class ShoppingService {
	@Autowired
	ProductCatalogProxy productCatalogProxy;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	OrderProxy orderProxy;
	@Autowired
	private ApplicationEventPublisher publisher;

	public void addToCart(String cartId, String productnumber, int quantity) {
		ProductDTO productsproduct = productCatalogProxy.getProduct(productnumber);
		//create a shopping product from a products product
		Product product = new Product(productsproduct.getProductnumber(),productsproduct.getDescription(),productsproduct.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent() && product != null) {
			ShoppingCart cart = cartOptional.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if (product != null) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartid(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}		
	}
	
	public ShoppingCartDTO getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
		  return ShoppingCartAdapter.getShoppingCartDTO(cart.get());
		else
			return null;
	}

	public void checkout(String cartId) {
		Optional<ShoppingCart> cartOpt = shoppingCartRepository.findById(cartId);
		if (cartOpt.isPresent()) {
			ShoppingCart cart = cartOpt.get();
			//publish event
			ShoppingCartCheckedOutEvent event = new ShoppingCartCheckedOutEvent(cart);
			publisher.publishEvent(event);
			
			orderProxy.createOrder(ShoppingCartAdapter.getShoppingCartDTO(cart));
		}		
	}
}
