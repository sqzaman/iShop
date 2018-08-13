package ishop.customers.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ishop.customers.payload.AddressRequest;
import ishop.customers.payload.CreditCardRequest;
import ishop.customers.payload.CustomerSignUpRequest;
import ishop.customers.service.CustomerService;
import ishop.security.CurrentUser;
import ishop.security.UserPrincipal;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerSignUpRequest customerSignUpRequest) {
		return customerService.createAccount(customerSignUpRequest);
	}
	
	@PostMapping(value = "/addAddress")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> addAddress(@Valid @RequestBody AddressRequest addressRequest, @CurrentUser UserPrincipal currentUser) {
		return customerService.addAddress(addressRequest, currentUser);
	}
	
	@PostMapping(value = "/addCreditCard")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> addCreditCard(@Valid @RequestBody CreditCardRequest creditCardRequest, @CurrentUser UserPrincipal currentUser) {
		return customerService.addCreditCard(creditCardRequest, currentUser);
	}
	
	@GetMapping("/get")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> getCustomer(@CurrentUser UserPrincipal currentUser) {
		return customerService.getCustomer(currentUser);
	}
}
