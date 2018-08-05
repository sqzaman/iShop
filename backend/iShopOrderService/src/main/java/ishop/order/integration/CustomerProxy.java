package ishop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ishop.order.service.OrderCustomerDTO;




@Component
public class CustomerProxy {
	@Autowired
	CustomerFeignClient customerClient;
	//@Autowired
	//private RestOperations restTemplate;
	@Value("${customersURL}")
	String customersURL;
	
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		//OrderCustomerDTO customer = restTemplate.getForObject(customersURL+"/ordercustomer/"+customerNumber, OrderCustomerDTO.class);
		OrderCustomerDTO customer = customerClient.getCustomer(customerNumber);
		return customer;
	};
	
	@FeignClient("WebshopCustomerService")
	interface CustomerFeignClient {
		@RequestMapping("/ordercustomer/{customerNumber}")
		public OrderCustomerDTO getCustomer(@PathVariable("customerNumber") String customerNumber);
	}
}



