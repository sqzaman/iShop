package shop.customers.domain;

import java.time.LocalDate;

public class CreditCard {
	private String number;
	private LocalDate validationDate;

	public CreditCard(String number, LocalDate validationDate) {
		super();
		this.number = number;
		this.validationDate = validationDate;
	}

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
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
