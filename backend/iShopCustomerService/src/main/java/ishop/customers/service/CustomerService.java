package ishop.customers.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ishop.customers.domain.Address;
import ishop.customers.domain.CreditCard;
import ishop.customers.domain.Customer;
import ishop.customers.dto.AccountDto;
import ishop.customers.integration.OAuth2Proxy;
import ishop.customers.payload.AccountRequest;
import ishop.customers.payload.AddressRequest;
import ishop.customers.payload.ApiResponse;
import ishop.customers.payload.CreditCardRequest;
import ishop.customers.payload.CustomerSignUpRequest;
import ishop.customers.repository.CustomerRepository;
import ishop.security.CurrentUser;
import ishop.security.UserPrincipal;

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

		AccountRequest account = new AccountRequest(customerSignUpRequest.getUsername(),
				customerSignUpRequest.getEmail(),
				customerSignUpRequest.getFirstName() + " " + customerSignUpRequest.getLastName(),
				customerSignUpRequest.getPassword());
		AccountDto responseEntity = oauth2Proxy.registerUser(account);

		if (responseEntity.isSuccess()) {
			Customer customer = new Customer(customerSignUpRequest.getFirstName(), customerSignUpRequest.getLastName(),
					customerSignUpRequest.getEmail(), customerSignUpRequest.getPhone());

			Customer result = customerRepository.save(customer);

			URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/customer/" + result.getCustomerId()).buildAndExpand(result.getCustomerId()).toUri();

			return ResponseEntity.created(location).body(new ApiResponse(true, "The Account is created successfully!"));
		} else {
			return new ResponseEntity(
					new ApiResponse(false,
							"Something problem in your data, please check! May be username already in use!"),
					HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> addAddress(AddressRequest addressRequest, UserPrincipal currentUser) {

		Customer customer = customerRepository.findByEmail(currentUser.getEmail());

		switch (addressRequest.getAddressType()) {

		case BILLING_ADDRESS:
			Address billingAddress = new Address(addressRequest.getStreet(), addressRequest.getCity(),
					addressRequest.getZip(), addressRequest.getState(), addressRequest.getCountry());
			customer.setBillingAddress(billingAddress);
			billingAddress.setCustomer(customer);
			customerRepository.save(customer);
			break;

		case SHIPPING_ADDRESS:
			Address shippingAddress = new Address(addressRequest.getStreet(), addressRequest.getCity(),
					addressRequest.getZip(), addressRequest.getState(), addressRequest.getCountry());
			customer.setShippingAddress(shippingAddress);
			shippingAddress.setCustomer(customer);
			customerRepository.save(customer);
			break;
		}

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer").buildAndExpand().toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "Address added successfully!"));
	}

	public ResponseEntity<?> addCreditCard(CreditCardRequest creditCardRequest, UserPrincipal currentUser) {

		Customer customer = customerRepository.findByEmail(currentUser.getEmail());

		CreditCard creditCard = new CreditCard(creditCardRequest.getNumber(), creditCardRequest.getValidationDate());
		List<CreditCard> creditCards = customer.getCreditCards();

		creditCard.setCustomer(customer);
		creditCards.add(creditCard);
		customer.setCreditCards(creditCards);
		customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer").buildAndExpand().toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "Credit card added successfully!"));
	}

	public ResponseEntity<?> getCustomer(UserPrincipal currentUser) {

		Customer customer = customerRepository.findByEmail(currentUser.getEmail());
		if(customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Specified customer is not available!"),
				HttpStatus.BAD_REQUEST);		


	}
}
