package ishop.customers.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 	private String number;
	private String validationDate;
	@ManyToOne
	private Customer customer;
	
	public CreditCard() {}
	
	public CreditCard(String number, String validationDate) {
		this.number = number;
		this.validationDate = validationDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}	
