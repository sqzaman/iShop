package ishop.customers.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreditCardRequest {
	
	@NotBlank
    @Size(min = 16, max = 40)
	private String number;
	
	@NotBlank
	@Size(min = 5, max = 10)
	private String validationDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}
	
}
