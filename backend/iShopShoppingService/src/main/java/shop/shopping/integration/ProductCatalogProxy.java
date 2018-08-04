package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.shopping.service.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;


@Component
public class ProductCatalogProxy {
	@Autowired
	ProductFeignClient productClient;

	@Value("${productsURL}")
	String productsURL;
	
	public ProductDTO getProduct(String productNumber) {
		//ProductDTO product = restTemplate.getForObject(productsURL+"/product/A33", ProductDTO.class);
		ProductDTO product = productClient.getProduct(productNumber);
		return product;
	};


	@FeignClient("WebshopProductService")
	interface ProductFeignClient {
		@RequestMapping("/get/{productNumber}")
		public ProductDTO getProduct(@PathVariable("productNumber") String productNumber);
	}
}
