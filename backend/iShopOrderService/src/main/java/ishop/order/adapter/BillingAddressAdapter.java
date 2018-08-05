package ishop.order.adapter;

import ishop.order.domain.Address;
import ishop.order.dto.CustomerDto;

public class BillingAddressAdapter {

	public static Address getBillingAddress(CustomerDto customerDto) {
		Address billingAddress = new Address(customerDto.getBillingAddress().getStreet(),
				customerDto.getBillingAddress().getCity(), customerDto.getBillingAddress().getZip(),
				customerDto.getBillingAddress().getState(), customerDto.getBillingAddress().getCountry());

		return billingAddress;
	}

}
