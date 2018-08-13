package ishop.customers.payload;

import javax.validation.constraints.*;

import org.springframework.core.annotation.Order;


public class CustomerUpdateRequest {
	
    @NotBlank(message = "Firstname cannot be empty!")
    @Size(min = 4, max = 40)
    @Order(1)
    private String firstname;
    
    @NotBlank(message = "Lastname cannot be empty!")
    @Size(min = 4, max = 40)
    @Order(2)
    private String lastname;
      
    @NotBlank(message = "Phone cannot be empty!")
    @Size(max = 40)
    private String phone;


	

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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
