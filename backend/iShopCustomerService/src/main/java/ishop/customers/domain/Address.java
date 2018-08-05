package ishop.customers.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 64)
	private String line;
	
	@NotBlank
	@Size(max = 64)
	private String city;
	
	@NotBlank
	@Size(max = 64)
	private String zip;
	
	@NotBlank
	@Size(max = 64)
	private String country;
	
	@OneToOne
	private Customer customer;
	
	public Address(String line, String city, String zip, String country) {
		super();
		this.line = line;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public Address() {
		super();
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
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
