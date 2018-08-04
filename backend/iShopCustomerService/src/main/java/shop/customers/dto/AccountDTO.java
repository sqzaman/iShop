package shop.customers.dto;

public class AccountDTO {
	
	private Long accountNumber;
	private String username;
	private String email;
	private String password;

	public AccountDTO(Long accountNumber, String username, String email, String password) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public AccountDTO() {
		super();
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
