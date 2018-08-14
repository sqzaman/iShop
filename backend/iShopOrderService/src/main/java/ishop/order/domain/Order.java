package ishop.order.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Order {
	@Id
	private String orderId;
	private LocalDateTime date;
	private OrderStatus status;
	private Customer customer;	
	private Address billingAddress;
	private Address shippingAddress;

	private ArrayList<OrderLine> orderlineList = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String orderId, Customer customer, Address billingAddress, Address shippingAddress, LocalDateTime date, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.date = date;
		this.status = status;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}


	private double getTotalPrice() {
		double totalPrice = 0.0;
		for (OrderLine oline : orderlineList) {
			totalPrice=totalPrice+(oline.getProduct().getPrice() * oline.getQuantity());
		}
		return totalPrice;
	}
	
	public void addOrderLine(OrderLine oline) {
		orderlineList.add(oline);		
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ArrayList<OrderLine> getOrderlineList() {
		return orderlineList;
	}

	public void setOrderlineList(ArrayList<OrderLine> orderlineList) {
		this.orderlineList = orderlineList;
	}

	public void confirm() {
		this.status = OrderStatus.CONFIRMED;		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	
	
}
