package ishop.shopping.dto;

import java.util.ArrayList;

public class ShoppingCartDTO {
	private String cartid;
	private double totalPrice;
	private ArrayList<CartLineDTO> cartlineList = new ArrayList<CartLineDTO>();


	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public ArrayList<CartLineDTO> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLineDTO> cartlineList) {
		this.cartlineList = cartlineList;
	}
	
	public void addCartLine(CartLineDTO cartLine) {
		cartlineList.add(cartLine);
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public double getTotalPrice() {
		return totalPrice;
	}
	
	

}
