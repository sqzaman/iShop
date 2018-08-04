package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import shop.shopping.service.ShoppingCartDTO;

@Component
public class OrderProxy {
	@Autowired
	OrderFeignClient orderClient;
	@Value("${ordersURL}")
	String ordersURL;

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {		
		//restTemplate.postForLocation(ordersURL+"/order/create", shoppingCartDTO);		
		orderClient.createOrder(shoppingCartDTO);
	};
	
	@FeignClient("WebshopOrderService")
	interface OrderFeignClient {
		//@RequestMapping("/product/{productNumber}")
		//public ProductDTO getProduct(@PathVariable("productNumber") String productNumber);
		@PostMapping("/create")
		public void createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO);
	}
}
