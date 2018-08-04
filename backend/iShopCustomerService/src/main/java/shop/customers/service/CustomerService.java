package shop.customers.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import shop.customers.domain.Customer;
import shop.customers.integration.OAuth2Proxy;
import shop.customers.payload.ApiResponse;
import shop.customers.payload.CustomerSignUpRequest;
import shop.customers.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OAuth2Proxy oauth2Proxy;
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> createAccount(CustomerSignUpRequest customerSignUpRequest) {
		
		if (customerRepository.existsByEmail(customerSignUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_GATEWAY);
		}
		
		if (customerRepository.existsByUsername(customerSignUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username already in use!"), HttpStatus.BAD_GATEWAY);
		}
		
		Customer customer = new Customer(customerSignUpRequest.getFirstname(), customerSignUpRequest.getLastname(),
				customerSignUpRequest.getUsername(), customerSignUpRequest.getEmail(), customerSignUpRequest.getPhone()); 
		
		Customer result = customerRepository.save(customer);
		
		
		/*** Begin communicate with Ouath2Service ***/
		
		//Account account = new Account(result.getCustomerId().toString(), customerSignUpRequest.getUsername(), customerSignUpRequest.getPassword());
		//AccountDTO responseEntity = oauth2Proxy.registerUser(account);
		
		/*** End communicate with Ouath2Service ***/
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer")
				.buildAndExpand(result.getCustomerId()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "The Account is created successfully!"));

	}
}
