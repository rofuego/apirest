package cl.sourcecode.apirest.dto;

import cl.sourcecode.apirest.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

	private Long id;

	private Long quantity;

	private Double price;

	private Double subtotal;

	private ProductEntity product;

}
