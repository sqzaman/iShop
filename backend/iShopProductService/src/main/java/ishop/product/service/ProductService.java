package ishop.product.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ishop.product.domain.Category;
import ishop.product.domain.Product;
import ishop.product.domain.ProductImage;
import ishop.product.domain.Stock;
import ishop.product.payload.ApiResponse;
import ishop.product.payload.CategoryRequest;
import ishop.product.payload.ProductRequest;
import ishop.product.payload.StockRequest;
import ishop.product.payload.StockUpdateRequest;
import ishop.product.repository.CategoryRepository;
import ishop.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public ResponseEntity<?> addProduct(ProductRequest productRequest) {

		Product product = new Product(productRequest.getProductId(), productRequest.getName(),
				productRequest.getDescription(), productRequest.getPrice(),
				categoryRepository.findById(productRequest.getCategoryId()).orElse(null));
		Product result = productRepository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/{productId}")
				.buildAndExpand(result.getProductId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Product has been added successfully!"));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> addCategory(CategoryRequest categoryRequest) {

		if (categoryRepository.existsByName(categoryRequest.getName())) {
			return new ResponseEntity(
					new ApiResponse(false, "Already there is category named " + categoryRequest.getName()),
					HttpStatus.BAD_REQUEST);
		}

		Category result = categoryRepository
				.save(new Category(categoryRequest.getName(), categoryRequest.getDescription()));

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/category/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Category has been added successfully!"));

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> updateCategory(CategoryRequest categoryRequest, Long catId) {
		/*
			if (categoryRepository.existsByName(categoryRequest.getName())) {
				return new ResponseEntity(
						new ApiResponse(false, "Already there is category named " + categoryRequest.getName()),
						HttpStatus.BAD_REQUEST);
			}
		*/
		Category category = categoryRepository.findById(catId).orElse(null);
		if (category != null) {
			category.setName(categoryRequest.getName());
			category.setDescription(categoryRequest.getDescription());
			Category result = categoryRepository.save(category);
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/category/{id}")
					.buildAndExpand(result.getId()).toUri();

			return ResponseEntity.created(location).body(new ApiResponse(true, "Category has been updated successfully!"));
		}

		return new ResponseEntity(
				new ApiResponse(false, "There is no such  category found!" + catId),
				HttpStatus.BAD_REQUEST);


	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getCategory(Optional<Integer> categoryId) {
		
		if(!categoryId.isPresent()) {
			List<Category> categories = categoryRepository.findAll();
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		}
		Optional<Category> category   = categoryRepository.findById(new Long(categoryId.get()));
		if(category.isPresent())
			return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
		else 
			return new ResponseEntity(new ApiResponse(false, "Specified category is not available!"),
					HttpStatus.BAD_REQUEST);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> setStock(StockRequest stockRequest) {
		Optional<Product> result = productRepository.findByProductId(stockRequest.getProductId());

		if (!result.isPresent()) {
			return new ResponseEntity(new ApiResponse(false, "Specified product is not valid product!"),
					HttpStatus.BAD_REQUEST);
		}

		Product product = result.get();
		Stock stock = new Stock(stockRequest.getQuantity(), stockRequest.getLocationCode());
		product.setStock(stock);
		productRepository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/{productId}")
				.buildAndExpand(product.getProductId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Stock has been added successfully!"));
	}

	public Stock getStock(Long productId) {
		Optional<Product> result = productRepository.findById(productId);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = product.getStock();
			return stock;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> updateStock(StockUpdateRequest stockUpdateRequest) {

		Optional<Product> result = productRepository.findByProductId(stockUpdateRequest.getProductId());

		if (!result.isPresent()) {
			return new ResponseEntity(new ApiResponse(false, "Specified product is not valid product!"),
					HttpStatus.BAD_REQUEST);
		}

		Product product = result.get();
		Stock stock = product.getStock();
		if (stock != null) {
			stock.setQuantity(stockUpdateRequest.getQuantity());
			product.setStock(stock);
			productRepository.save(product);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/{productId}")
				.buildAndExpand(product.getProductId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Stock has been updated successfully!"));

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getProduct(Optional<String> productId) {		
		if(!productId.isPresent()) {
			List<Product> products = productRepository.findAll();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		
		Optional<Product> result = productRepository.findByProductId(productId.get());
		
		if(productId.isPresent())			
			return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
		else 
			return new ResponseEntity(new ApiResponse(false, "Specified product is not available!"),
					HttpStatus.BAD_REQUEST);		

		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getProductById(Long id) {		
		
		Optional<Product> result = productRepository.findById(id);
		
		if(result.isPresent())			
			return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
		else 
			return new ResponseEntity(new ApiResponse(false, "Specified product is not available!"),
					HttpStatus.BAD_REQUEST);		

		
	}
	
	public ResponseEntity<?> updateProduct(ProductRequest productRequest, Long productId) {

		Product product = productRepository.findById(productId).orElse(null);
		if (product != null) {
			product.setProductId(productRequest.getProductId());
			product.setName(productRequest.getName());
			product.setDescription(productRequest.getDescription());
			product.setPrice(productRequest.getPrice());
			product.setCategory(categoryRepository.findById(productRequest.getCategoryId()).orElse(null));
			Product result = productRepository.save(product);

			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/{productId}")
					.buildAndExpand(result.getProductId()).toUri();

			return ResponseEntity.created(location).body(new ApiResponse(true, "Product has been updated successfully!"));
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Specified product is not available!"),
					HttpStatus.BAD_REQUEST);		
		}

		

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getImagesProductById(String id) {		
		
		Optional<Product> result = productRepository.findByProductId(id);
		
		if(result.isPresent())	{
			List<ProductImage> productImages = result.get().getProductImages();
			return new ResponseEntity<List<ProductImage>>(productImages, HttpStatus.OK);
		}
			
		else 
			return new ResponseEntity(new ApiResponse(false, "Specified product is not available!"),
					HttpStatus.BAD_REQUEST);		

		
	}
}
