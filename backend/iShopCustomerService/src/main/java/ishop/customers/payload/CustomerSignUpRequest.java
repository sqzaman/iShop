package ishop.customers.payload;

import javax.validation.constraints.*;

import org.springframework.core.annotation.Order;


public class CustomerSignUpRequest {
	
    @NotBlank(message = "Firstname cannot be empty!")
    @Size(min = 4, max = 40)
    @Order(1)
    private String firstName;
    
    @NotBlank(message = "Lastname cannot be empty!")
    @Size(min = 4, max = 40)
    @Order(2)
    private String lastName;

    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 4, max = 40)
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Size(max = 40)
    @Email
    private String email;
    
    @NotBlank(message = "Phone cannot be empty!")
    @Size(max = 40)
    private String phone;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 6, max = 20)
    private String password;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
