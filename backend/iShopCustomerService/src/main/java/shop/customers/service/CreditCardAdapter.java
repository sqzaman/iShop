package shop.customers.service;

import shop.customers.domain.CreditCard;

public class CreditCardAdapter {

	public static CreditCard getCreditCard(CreditCardDTO creditcardDTO) {
		CreditCard creditcard = new CreditCard(
				creditcardDTO.getNumber(),
				creditcardDTO.getValidationDate()
				);		
		return creditcard;				
	}
	
	public static CreditCardDTO getCreditCardDTO(CreditCard creditcard) {
		CreditCardDTO creditcardDTO = new CreditCardDTO(
				creditcard.getNumber(),
				creditcard.getValidationDate()
				);		
		return creditcardDTO;				
	}
}
