package ishop.product.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductRequest {
	    @NotBlank
	    @Size(min = 4, max = 64)
	    private String productId;

	    @NotBlank
	    @Size(min = 4, max = 64)
	    private String name;

	    @Size(max = 255)
	    private String description;

	    @NotNull
	    private Double price;
	    
	    @NotNull
	    private Long categoryId;

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

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public void setPrice(Double price) {
			this.price = price;
		}
		

}
