package ishop.customers.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ishop.customers.domain.Customer;
import ishop.customers.dto.AccountDto;
import ishop.customers.integration.OAuth2Proxy;
import ishop.customers.payload.AccountRequest;
import ishop.customers.payload.ApiResponse;
import ishop.customers.payload.CustomerSignUpRequest;
import ishop.customers.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OAuth2Proxy oauth2Proxy;
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> createAccount(CustomerSignUpRequest customerSignUpRequest) {
		
		if (customerRepository.existsByEmail(customerSignUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}
		
	/*** Begin communicate with Ouath2Service ***/
		
		AccountRequest account = new AccountRequest(customerSignUpRequest.getUsername(), customerSignUpRequest.getEmail(), 
				customerSignUpRequest.getFirstName() + " " + customerSignUpRequest.getLastName(), 
				customerSignUpRequest.getPassword());
		AccountDto responseEntity = oauth2Proxy.registerUser(account);
		
		/*** End communicate with Ouath2Service ***/

		if(responseEntity.isSuccess()) {
			Customer customer = new Customer(customerSignUpRequest.getFirstName(), customerSignUpRequest.getLastName(),
					customerSignUpRequest.getEmail(), customerSignUpRequest.getPhone()); 
			
			Customer result = customerRepository.save(customer);
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer/" + result.getCustomerId())
					.buildAndExpand(result.getCustomerId()).toUri();
			
			return ResponseEntity.created(location).body(new ApiResponse(true, "The Account is created successfully!"));
		} else {
			return new ResponseEntity(new ApiResponse(false, "Something problem in your data, please check! May be username already in use!"), HttpStatus.BAD_REQUEST);
		}

		
		
	
		
	

	}
}
