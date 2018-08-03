package ishop.product.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StockRequest {

	@NotBlank
	@Size(min = 4, max = 64)
	private String productId;

	@NotBlank
	int quantity;

	@NotBlank
	@Size(max = 64)
	String locationCode;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

}
