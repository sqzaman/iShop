package ishop.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	String productId;
	String name;
	double price;
	String description;


	public Product(String productId, String name, String description, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Product() {

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
