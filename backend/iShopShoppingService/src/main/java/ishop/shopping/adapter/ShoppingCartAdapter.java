package ishop.shopping.adapter;

import ishop.shopping.adapter.ProductAdapter;
import ishop.shopping.domain.CartLine;
import ishop.shopping.domain.ShoppingCart;
import ishop.shopping.dto.CartLineDto;
import ishop.shopping.dto.ShoppingCartDto;

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
	*/
	public static ShoppingCartDto getShoppingCartDto(ShoppingCart shoppingCart) {
		ShoppingCartDto shoppingCartDTO = new ShoppingCartDto();
		shoppingCartDTO.setCartid(shoppingCart.getCartId());
		shoppingCartDTO.setTotalPrice(shoppingCart.getTotalPrice());		
		for (CartLine cartLine : shoppingCart.getCartlineList()) {
			CartLineDto cartLineDTO = new CartLineDto();
			cartLineDTO.setQuantity(cartLine.getQuantity());
			cartLineDTO.setProduct(ProductAdapter.getProductDto(cartLine.getProduct()));
			shoppingCartDTO.addCartLine(cartLineDTO);
		}
		return shoppingCartDTO;
	}

}
