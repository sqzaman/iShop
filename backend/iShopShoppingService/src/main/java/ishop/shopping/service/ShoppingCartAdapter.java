package ishop.shopping.service;

import ishop.shopping.domain.CartLine;
import ishop.shopping.domain.ShoppingCart;

public class ShoppingCartAdapter {
	/*
	public static ShoppingCart getShoppingCart(ShoppingCartDto shoppingCartDTO) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCartid(shoppingCartDTO.getCartid());
		for (CartLineDTO cartLine : shoppingCartDTO.getCartlineList()) {
			shoppingCart.addToCart(ProductAdapter.getProduct(cartLine.getProduct()), cartLine.getQuantity());
		}

		return shoppingCart;
	}

	public static ShoppingCartDTO getShoppingCartDTO(ShoppingCart shoppingCart) {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setCartid(shoppingCart.getCartid());
		shoppingCartDTO.setTotalPrice(shoppingCart.getTotalPrice());		
		for (CartLine cartLine : shoppingCart.getCartlineList()) {
			CartLineDTO cartLineDTO = new CartLineDTO();
			cartLineDTO.setQuantity(cartLine.getQuantity());
			cartLineDTO.setProduct(ProductAdapter.getProductDTO(cartLine.getProduct()));
			shoppingCartDTO.addCartLine(cartLineDTO);
		}
		return shoppingCartDTO;
	}
	*/
}
