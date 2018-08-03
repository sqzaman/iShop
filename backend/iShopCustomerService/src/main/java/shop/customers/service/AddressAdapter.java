package shop.customers.service;

import shop.customers.domain.Address;

public class AddressAdapter {
	public static Address getAddress(AddressDTO addressDTO) {
		Address address = new Address(
				addressDTO.getStreet(),
				addressDTO.getCity(),
				addressDTO.getZip(),
				addressDTO.getCountry()
				);		
		return address;				
	}
	
	public static AddressDTO getAddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO(
				address.getStreet(),
				address.getCity(),
				address.getZip(),
				address.getCountry()
				);		
		return addressDTO;				
	}
}
