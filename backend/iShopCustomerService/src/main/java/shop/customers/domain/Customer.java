package shop.customers.domain;

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
	@Size(max = 64)
	private String username;
	
	@NotBlank
	@NaturalId
	@Size(max = 64)
	private String email;
	
	@NotBlank
	@Size(max = 64)
	private String phone;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shippingAddress", referencedColumnName="id", insertable=false, updatable=false)
	private Address shippingAddress;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billingAddress", referencedColumnName="id", insertable=false, updatable=false)
	private Address billingAddress;
	
	public Customer() {
	}

	public Customer(Long customerId, String firstname, String lastname, String email, String phone) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	
	public Customer(String firstname, String lastname, String username, String email, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
