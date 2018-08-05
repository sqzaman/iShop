package ishop.customers.payload;

public class AccountRequest {
	private String username;
	private String email;
	private String name;
	private String password;

	public AccountRequest(String username, String email, String fullName, String password) {
		super();
		this.username = username;
		this.email = email;
		this.name = fullName;
		this.password = password;
	}

	public AccountRequest() {
		super();
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
