package cl.sourcecode.apirest.dto;

import java.util.List;

public class ProductDto {

	private Long id;

	private String name;

	private Double price;

	private Long quantity;

	private CategoryDto category;

	private List<TagDto> tags;

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

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}

	public ProductDto(Long id, String name, Double price, Long quantity, CategoryDto category, List<TagDto> tags) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.tags = tags;
	}

	public ProductDto() {
		super();
	}

}
