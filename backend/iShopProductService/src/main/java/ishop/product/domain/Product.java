package ishop.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Id;

@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = { "product_id" }) })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonIgnore
	private Long id;

	@NotBlank
	@Size(max = 64)
	@Column(name = "product_id")
	private String productId;

	@NotBlank
	@Size(max = 64)
	private String name;

	@NotBlank
	@Size(max = 255)
	private String description;

	// @NotBlank
	@Column(precision = 16, scale = 2)
	private Double price;

	@OneToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonInclude()
	@Transient
	private Long categoryId;
	
	

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ProductImage> productImages = new ArrayList<ProductImage>();

	public Product() {
	}

	public Product(String productId, String name, String description, double price, Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getCategoryId() {
		return this.category.getId();
	}

}
