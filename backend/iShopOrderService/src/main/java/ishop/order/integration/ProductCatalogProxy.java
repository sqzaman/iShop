package ishop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
public class ProductCatalogProxy {

	@Autowired
	ProductFeignClient productClient;
	//@Autowired
	//private RestOperations restTemplate;
	@Value("${productsURL}")
	String productsURL;

	public void updateStock(String productNumber, int quantity) {
		//restTemplate.postForLocation(productsURL + "/updateStock/" + productNumber + "/" + quantity, null);
		productClient.updateStock(productNumber, quantity);
	};

	@FeignClient("WebshopProductService")
	interface ProductFeignClient {
		@RequestMapping("/updateStock/{productNumber}/{quantity}")
		public void updateStock(@PathVariable("productNumber") String productNumber,
				@PathVariable("quantity") int quantity);
	}
}
