package shop.shopping.domain;

import java.util.Date;

public class ShoppingCartCheckedOutEvent {
	private ShoppingCart cart;
	private Date date= new Date();

	public ShoppingCart getCart() {
		return cart;
	}

	public ShoppingCartCheckedOutEvent(ShoppingCart cart) {
		this.cart = cart;
	}

	public Date getDate() {
		return date;
	}	
}
