package cl.sourcecode.apirest.dto;

public class ProductResponseDto {

	private Long id;

	private String name;

	private Double price;

	private Long quantity;

	private CategoryRequestDto category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public ProductResponseDto(Long id, String name, Double price, Long quantity, CategoryRequestDto category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public ProductResponseDto() {
		super();
	}

}
