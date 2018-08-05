package ishop.order.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class OrderDTO {
	@Id
	private String ordernumber;
	private Date date;
	private String status;
	private OrderCustomerDTO customer;

	private ArrayList<OrderLineDTO> orderlineList = new ArrayList<OrderLineDTO>();

	public OrderDTO() {
	}

	public OrderDTO(String ordernumber, Date date, String status) {
		super();
		this.ordernumber = ordernumber;
		this.date = date;
		this.status = status;
	}

	public void print() {
		System.out.println("Content of the order:");
		System.out.println("Ordernr :"+ordernumber+" , Date : "+date+" , Status : "+status);
		for (OrderLineDTO oline : orderlineList) {
			System.out.println(oline.getQuantity() + " " + oline.getProduct().getProductnumber() + " "
					+ oline.getProduct().getDescription() + " " + oline.getProduct().getPrice());
		}
		System.out.println("Total price =" + getTotalPrice());
		if(customer != null)
		  System.out.println("Customername =" + customer.getFirstname()+" "+customer.getLastname());
	}

	public OrderCustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(OrderCustomerDTO customer) {
		this.customer = customer;
	}

	private double getTotalPrice() {
		double totalPrice = 0.0;
		for (OrderLineDTO oline : orderlineList) {
			totalPrice=totalPrice+(oline.getProduct().getPrice() * oline.getQuantity());
		}
		return totalPrice;
	}
	
	public void addOrderLine(OrderLineDTO oline) {
		orderlineList.add(oline);		
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<OrderLineDTO> getOrderlineList() {
		return orderlineList;
	}

	public void setOrderlineList(ArrayList<OrderLineDTO> orderlineList) {
		this.orderlineList = orderlineList;
	}
	
	

}
