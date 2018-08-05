package ishop.order.adapter;

import ishop.order.domain.Address;
import ishop.order.dto.CustomerDto;

public class ShippingAddressAdapter {

	public static Address getShippingAddress(CustomerDto customerDto) {
		Address shippingAddress = new Address(customerDto.getShippingAddress().getStreet(),
				customerDto.getShippingAddress().getCity(), customerDto.getShippingAddress().getZip(),
				customerDto.getShippingAddress().getState(), customerDto.getShippingAddress().getCountry());
		return shippingAddress;
	}

}
