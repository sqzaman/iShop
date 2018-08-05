package ishop.customers.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ishop.customers.domain.AddressType;

public class AddressRequest {
	
	@NotBlank
    @Size(min = 4, max = 255)
	private String line;
	
	@NotBlank
    @Size(min = 4, max = 10)
	private String zip;
	
	@NotBlank
    @Size(min = 2, max = 20)
	private String city;
	
	@NotBlank
    @Size(min = 2, max = 20)
	private String country;
	
	private AddressType addressType;
	
	AddressRequest(String line, String zip, String city, String country, AddressType addressType) {
		this.line = line;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.addressType = addressType;
	}
	
	AddressRequest() {
		
	}
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
}
