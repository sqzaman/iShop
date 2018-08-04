package ishop.shopping.service;

import ishop.shopping.domain.Product;

public class ProductAdapter {
	public static Product getProduct(ProductDTO productDTO) {
		Product product = new Product(
				productDTO.getProductnumber(),
				productDTO.getDescription(),
				productDTO.getPrice()
				);		
		return product;				
	}
	
	public static ProductDTO getProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO(
				product.getProductnumber(),
				product.getDescription(),
				product.getPrice()
				);		
		return productDTO;				
	}
}
