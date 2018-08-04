package shop.shopping.domain;

import java.util.ArrayList;
import java.util.Iterator;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ShoppingCart {
	@Id
	String cartid;
	
	ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();

	public void addToCart(Product product, int quantity) {
		for (CartLine cline : cartlineList) {
			if (cline.getProduct().getProductnumber().equals(product.getProductnumber())) {
				cline.setQuantity(cline.getQuantity()+quantity);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(quantity);
		cartlineList.add(cline);
	}
	


	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cline : cartlineList) {
			System.out.println(cline.getQuantity() + " "
					+ cline.getProduct().getProductnumber() + " "
					+ cline.getProduct().getDescription() + " "
					+ cline.getProduct().getPrice());
		}
		System.out.println("Total price ="+getTotalPrice());
	}
	
	public double getTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cline : cartlineList) {
			totalPrice=totalPrice+(cline.getProduct().getPrice() * cline.getQuantity());
		}
		return totalPrice;
	}
	
	public void removeFromCart(Product product){
		Iterator<CartLine> iter = cartlineList.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (cline.getProduct().getProductnumber().equals(product.getProductnumber())){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public ArrayList<CartLine> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLine> cartlineList) {
		this.cartlineList = cartlineList;
	}

}
