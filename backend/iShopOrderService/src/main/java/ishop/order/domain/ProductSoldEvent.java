package ishop.order.domain;

public class ProductSoldEvent {
	private String productNumber;
	private int quantity;

	public ProductSoldEvent(String productNumber, int quantity) {
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
