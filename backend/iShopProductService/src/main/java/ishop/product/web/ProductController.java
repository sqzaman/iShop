package ishop.product.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> setStock(@Valid @RequestBody StockRequest stockRequest){
		return productService.setStock(stockRequest);
	}
	
	@PostMapping(value = "/updateStock")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateStock(@Valid @RequestBody StockUpdateRequest stockUpdateRequest){
		return productService.updateStock(stockUpdateRequest);
	}
	
	@GetMapping(value = {"/get", "/get/{id}"}) // using productId
	public ResponseEntity<?> getProduct(@PathVariable(value="id", required=false) Optional<String> id) {
		return productService.getProduct(id);
	}
	
	
	@GetMapping(value = {"/getById/{id}"}) // using id
	public ResponseEntity<?> getProductById(@PathVariable(value="id", required=true) Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequest productRequest, @PathVariable(value="id", required=true) Long id) {
		return productService.updateProduct(productRequest, id);
	}
	
	@GetMapping(value = {"/getImagesByProductId/{id}"}) // using id
	public ResponseEntity<?> getImagesProductById(@PathVariable(value="id", required=true) String id) {
		return productService.getImagesProductById(id);
	}
}
