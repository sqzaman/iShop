package ishop.order.domain;

import ishop.order.service.OrderDTO;

public class OrderConfirmedEvent {
	private OrderDTO orderDTO;

	public OrderConfirmedEvent(OrderDTO orderDTO) {
		super();
		this.orderDTO = orderDTO;
	}

	public OrderDTO getOrder() {
		return orderDTO;
	}
}
