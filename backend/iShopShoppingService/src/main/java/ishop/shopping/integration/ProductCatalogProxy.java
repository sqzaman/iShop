package ishop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ishop.shopping.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;


@Component
public class ProductCatalogProxy {
	@Autowired
	ProductFeignClient productClient;
	
	public ProductDto getProduct(String productNumber) {
		ProductDto product = productClient.getProduct(productNumber);
		return product;
	};


	@FeignClient("iShopProductService")
	interface ProductFeignClient {
		@RequestMapping("/get/{productId}")
		public ProductDto getProduct(@PathVariable("productId") String productId);
	}
}
