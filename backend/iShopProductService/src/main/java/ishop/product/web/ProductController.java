package ishop.product.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ishop.product.payload.ProductRequest;
import ishop.product.payload.StockRequest;
import ishop.product.payload.StockUpdateRequest;
import ishop.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest productRequest) {
		return productService.addProduct(productRequest);
	}

	@PostMapping(value = "/setStock")
	public ResponseEntity<?> setStock(@Valid @RequestBody StockRequest stockRequest){
		return productService.setStock(stockRequest);
	}
	
	@PostMapping(value = "/updateStock")
	public ResponseEntity<?> updateStock(@Valid @RequestBody StockUpdateRequest stockUpdateRequest){
		return productService.updateStock(stockUpdateRequest);
	}
}
