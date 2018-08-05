package ishop.order.service;

import ishop.order.domain.Order;
import ishop.order.domain.OrderLine;

public class OrderAdapter {
	public static Order getOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrdernumber(orderDTO.getOrdernumber());
		order.setDate(orderDTO.getDate());
		order.setStatus(orderDTO.getStatus());
		for (OrderLineDTO orderLineDTO : orderDTO.getOrderlineList()) {
			OrderLine orderLine = new OrderLine();
			orderLine.setQuantity(orderLineDTO.getQuantity());
			orderLine.setProduct(ProductAdapter.getProduct(orderLineDTO.getProduct()));
			order.addOrderLine(orderLine);
		}
		return order;
	}

	public static OrderDTO getOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrdernumber(order.getOrdernumber());
		orderDTO.setDate(order.getDate());
		orderDTO.setStatus(order.getStatus());

		for (OrderLine orderLine : order.getOrderlineList()) {
			OrderLineDTO orderLineDTO = new OrderLineDTO();
			orderLineDTO.setQuantity(orderLine.getQuantity());
			orderLineDTO.setProduct(ProductAdapter.getProductDTO(orderLine.getProduct()));
			orderDTO.addOrderLine(orderLineDTO);
		}

		if (order.getCustomer() != null) {
			OrderCustomerDTO orderCustomerDTO = OrderCustomerAdapter.getOrderCustomerDTO(order.getCustomer());
			orderDTO.setCustomer(orderCustomerDTO);
		}
		return orderDTO;
	}
}
