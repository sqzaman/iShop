package ishop.customers.web;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ishop.customers.payload.AddressRequest;
import ishop.customers.payload.CreditCardRequest;
import ishop.customers.payload.CustomerSignUpRequest;
import ishop.customers.payload.CustomerUpdateRequest;
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
	
    @GetMapping("/getRole")
    public ResponseEntity<?> getRole(@CurrentUser UserPrincipal currentUser) {
    	
    	//return new ResponseEntity<List<UploadFileResponse>>(uploadFileResponses, HttpStatus.OK);
    	return new  ResponseEntity<Collection<? extends GrantedAuthority>>(currentUser.getAuthorities(), HttpStatus.OK);
         // return userService.createUser(signUpRequest);

    }
	
	@PostMapping(value = "/update")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest, @CurrentUser UserPrincipal currentUser) {
		return customerService.updateCustomert(customerUpdateRequest, currentUser);
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
