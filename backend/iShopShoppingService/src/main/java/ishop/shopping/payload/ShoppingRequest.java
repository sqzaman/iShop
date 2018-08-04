package ishop.shopping.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;


public class ShoppingRequest {
	
		private String cartId;
		
	    @NotBlank
	    @Size(min = 4, max = 64)
	    private String productId;

	    @NotNull
	    //@Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="quantity must be a valid positive number")
	    private Integer quantity;

	  
		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getCartId() {
			return cartId;
		}

		public void setCartId(String cartId) {
			this.cartId = cartId;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}		

}
