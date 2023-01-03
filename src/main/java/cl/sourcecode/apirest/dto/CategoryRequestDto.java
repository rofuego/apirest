package cl.sourcecode.apirest.dto;

public class CategoryRequestDto {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryRequestDto(String name) {
		super();
		this.name = name;
	}

	public CategoryRequestDto() {
		super();
	}

}
