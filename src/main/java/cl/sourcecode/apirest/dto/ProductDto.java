package cl.sourcecode.apirest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Long id;

	private String name;

	private Double price;

	private Long quantity;

	private CategoryDto category;

	private List<TagDto> tags;

}
