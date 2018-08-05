package shop.customers.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.customers.domain.Account;
import shop.customers.dto.AccountDTO;

@Component
public class OAuth2Proxy {
	
	@Autowired
	OAuth2FeignClient oauth2Client;
	
	public AccountDTO registerUser(Account account) {
		AccountDTO result = oauth2Client.createUser(account);
		return result;
	};
	
	@FeignClient("iShopOAuth2Service")
	interface OAuth2FeignClient {
		@RequestMapping(value="/signup",method=RequestMethod.POST)
		public AccountDTO createUser(@ModelAttribute Account account);
	}
}
