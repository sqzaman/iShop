package ishop.product.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ishop.product.payload.CategoryRequest;
import ishop.product.payload.ProductRequest;
import ishop.product.payload.StockRequest;
import ishop.product.payload.StockUpdateRequest;
import ishop.product.service.ProductService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ProductService productService;

	@PostMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
		return productService.addCategory(categoryRequest);
	}
	
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest, @PathVariable(value="id", required = true) Long catId) {
		return productService.updateCategory(categoryRequest, catId);
	}
	
	@GetMapping(value = {"/get", "/get/{id}"})
	public ResponseEntity<?> getCategory(@PathVariable(value="id",required=false) Optional<Integer> id) {
		return productService.getCategory(id);
	}
}
