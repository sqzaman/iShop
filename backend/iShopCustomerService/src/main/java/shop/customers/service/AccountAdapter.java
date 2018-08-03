package shop.customers.service;

import shop.customers.domain.Account;

public class AccountAdapter {

	public static Account getAccount(AccountDTO accountDTO) {
		Account creditcard = new Account(
				accountDTO.getAccountNumber(),
				accountDTO.getUsername(),
				accountDTO.getPassword()
				);		
		return creditcard;				
	}
	
	public static AccountDTO getAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO(
				account.getAccountNumber(),
				account.getUsername(),
				account.getPassword()
				);		
		return accountDTO;				
	}
}
