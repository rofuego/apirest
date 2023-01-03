package cl.sourcecode.apirest.service;

import cl.sourcecode.apirest.dto.ProductRequestDto;
import cl.sourcecode.apirest.dto.ProductResponseDto;

public interface ProductService {

	public Iterable<ProductResponseDto> getAll();

	public ProductResponseDto get(Long id);

	public ProductResponseDto save(ProductRequestDto product);

	public void delete(Long id);
}
