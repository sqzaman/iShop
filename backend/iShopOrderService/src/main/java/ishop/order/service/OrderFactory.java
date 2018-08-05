package ishop.order.service;

import java.util.Date;

import ishop.order.domain.Order;
import ishop.order.domain.OrderLine;
import ishop.order.domain.OrderStatus;
import ishop.order.domain.Product;
import ishop.order.dto.CartLineDto;
import ishop.order.dto.ShoppingCartDto;




public class OrderFactory {
	
	public static Order createOrder(ShoppingCartDto cartDto) {
		Order order = new Order(cartDto.getCartid(), new Date(),   OrderStatus.PLACED);
		for (CartLineDto cline : cartDto.getCartlineList()) {
			OrderLine oline = new OrderLine();
			//create an order product from a shopping product
			Product product = new Product(cline.getProduct().getProductId(), cline.getProduct().getName(), 
					cline.getProduct().getDescription(), cline.getProduct().getPrice());
			oline.setProduct(product);
			oline.setQuantity(cline.getQuantity());
			order.addOrderLine(oline);
		}
		return order;
	}
}
