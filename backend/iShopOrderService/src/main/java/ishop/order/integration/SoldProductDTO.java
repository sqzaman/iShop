package ishop.order.integration;

public class SoldProductDTO {
	private String productNumber;
	private int quantity;

	public SoldProductDTO(String productNumber, int quantity) {
		super();
		this.productNumber = productNumber;
		this.quantity = quantity;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public int getQuantity() {
		return quantity;
	}

}
