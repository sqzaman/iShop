package ishop.order.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ishop.order.dto.CustomerDto;
import ishop.order.dto.ProductImageDto;
import ishop.order.dto.ProductImagesDto;


@Component
public class ProductProxy {

	@Autowired
	ProductFeignClient productClient;

	public List<ProductImageDto> getProductImages(String productId) {
		List<ProductImageDto> productImages = productClient.getImagesByProductId(productId);
		return productImages;
	};
	
	@FeignClient("iShopProductService")
	interface ProductFeignClient {
		@RequestMapping("/getImagesByProductId/{id}")
		public List<ProductImageDto> getImagesByProductId(@PathVariable("id") String productId);
	}

}
