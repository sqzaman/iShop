package ishop.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.Id;

@Entity
@Table(name = "stock")
public class Stock {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@NotBlank
	int quantity;
	
	@NotBlank
    @Size(max = 64)
	String locationcode;

	public Stock(int quantity, String locationcode) {
		super();
		this.quantity = quantity;
		this.locationcode = locationcode;
	}

	public Stock() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocationcode() {
		return locationcode;
	}

	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}

}
