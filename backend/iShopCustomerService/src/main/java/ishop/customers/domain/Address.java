package ishop.customers.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 64)
	private String street;
	
	
	@NotBlank
	@Size(max = 64)
	private String city;
	
	@NotBlank
	@Size(max = 64)
	private String zip;
	
	@NotBlank
	@Size(max = 64)
	private String state;
	
	@NotBlank
	@Size(max = 64)
	private String country;
	
	@JsonIgnore
	@OneToOne
	private Customer customer;
	
	public Address(String street, String city, String zip, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
	}

	public Address() {
		super();
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
