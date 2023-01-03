package cl.sourcecode.apirest.dto;

public class ProductRequestDto {

	private String name;

	private Double price;

	private Long quantity;

	private CategoryRequestDto category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public CategoryRequestDto getCategory() {
		return category;
	}

	public void setCategory(CategoryRequestDto category) {
		this.category = category;
	}

	public ProductRequestDto(String name, Double price, Long quantity, CategoryRequestDto category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public ProductRequestDto() {
		super();
	}

}
