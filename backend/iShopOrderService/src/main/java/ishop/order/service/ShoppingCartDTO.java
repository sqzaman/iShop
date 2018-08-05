package ishop.order.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ishop.order.domain.OrderLine;

public class ShoppingCartDTO {
	private String cartid;
	private double totalPrice;
	private ArrayList<CartLineDto> cartlineList = new ArrayList<CartLineDto>();


	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLineDto cline : cartlineList) {
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
