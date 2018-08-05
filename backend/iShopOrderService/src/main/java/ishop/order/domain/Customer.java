package ishop.order.domain;




public class Customer {
	private String customerNumber;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;


	public Customer(String customerNumber, String firstname, String lastname, String email, String phone) {
		super();
		this.customerNumber = customerNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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


}
