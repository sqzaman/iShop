package ishop.customers.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ishop.customers.dto.AccountDto;
import ishop.customers.payload.AccountRequest;

@Component
public class OAuth2Proxy {
	
	@Autowired
	OAuth2FeignClient oauth2Client;
	
	public AccountDto registerUser(AccountRequest account) {
		AccountDto result = oauth2Client.createUser(account);
		return result;
	};
	
	@FeignClient("iShopOAuth2Service")
	interface OAuth2FeignClient {
		@RequestMapping(value="/auth/signup",method=RequestMethod.POST)
		public AccountDto createUser(@RequestBody AccountRequest account);
	}
}
