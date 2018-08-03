package shop.customers.service;

import java.time.LocalDate;

public class CreditCardDTO {
	private String number;
	private LocalDate validationDate;

	public CreditCardDTO(String number, LocalDate validationDate) {
		super();
		this.number = number;
		this.validationDate = validationDate;
	}

	public CreditCardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "credit card:"+number+" , "+validationDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(LocalDate validationDate) {
		this.validationDate = validationDate;
	}

}
