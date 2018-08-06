package ishop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ishop.order.dto.CustomerDto;





@Component
public class CustomerProxy {
	@Autowired
	CustomerFeignClient customerClient;

	public CustomerDto getOrderCustomer(Long customerId) {
		CustomerDto customer = customerClient.getCustomer();
		return customer;
	};
	
	@FeignClient("iShopCustomerService")
	interface CustomerFeignClient {
		@GetMapping("/get")
		public CustomerDto getCustomer();
	}
}



