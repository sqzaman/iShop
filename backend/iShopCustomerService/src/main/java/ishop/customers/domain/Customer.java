package ishop.customers.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotBlank
	@Size(max = 64)
	private String firstname;
	
	@NotBlank
	@Size(max = 64)
	private String lastname;
	

	@NotBlank
	@NaturalId
	@Size(max = 64)
	private String email;
	
	@NotBlank
	@Size(max = 64)
	private String phone;
	
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "shippingAddress", referencedColumnName="id", insertable=false, updatable=false)
	@OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;
	
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "billingAddress", referencedColumnName="id", insertable=false, updatable=false)
	@OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();
	
	public Customer() {
	}

	public Customer(String firstname, String lastname, String email, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

}
