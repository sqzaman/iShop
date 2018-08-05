package ishop.order.adapter;

import ishop.order.domain.Customer;
import ishop.order.dto.CustomerDto;

public class CustomerAdapter {

	public static Customer getCustomer(CustomerDto customerDto) {
		Customer customer = new Customer(customerDto.getCustomerId(), customerDto.getFirstname(),
				customerDto.getLastname(), customerDto.getEmail(), customerDto.getPhone());

		return customer;
	}

}
