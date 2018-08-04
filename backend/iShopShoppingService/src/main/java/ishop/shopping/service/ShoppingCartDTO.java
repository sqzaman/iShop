package ishop.shopping.service;

import java.util.ArrayList;

public class ShoppingCartDTO {
	private String cartid;
	private double totalPrice;
	private ArrayList<CartLineDTO> cartlineList = new ArrayList<CartLineDTO>();


	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLineDTO cline : cartlineList) {
			System.out.println(cline.getQuantity() + " "
					+ cline.getProduct().getProductnumber() + " "
					+ cline.getProduct().getDescription() + " "
					+ cline.getProduct().getPrice());
		}
		System.out.println("Total price = "+totalPrice);
	}
	
	

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
