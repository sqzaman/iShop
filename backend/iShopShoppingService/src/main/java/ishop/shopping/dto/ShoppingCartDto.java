package ishop.shopping.dto;

import java.util.ArrayList;

public class ShoppingCartDto {
	private String cartid;
	private double totalPrice;
	private ArrayList<CartLineDto> cartlineList = new ArrayList<CartLineDto>();


	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public ArrayList<CartLineDto> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLineDto> cartlineList) {
		this.cartlineList = cartlineList;
	}
	
	public void addCartLine(CartLineDto cartLine) {
		cartlineList.add(cartLine);
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public double getTotalPrice() {
		return totalPrice;
	}
	
	

}
