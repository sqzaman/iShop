package ishop.order.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class ProductDto {
	String productId;
	double price;
	String name;
	String description;

	public ProductDto(String productId, String name, String description, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public ProductDto() {

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
