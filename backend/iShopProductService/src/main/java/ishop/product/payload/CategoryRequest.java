package ishop.product.payload;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {

	@NotBlank
	@Size(max = 64)
	private String name;

	@NotBlank
	@Size(max = 255)
	private String description;


	public CategoryRequest() {
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
