package cl.sourcecode.apirest.service;

import java.util.List;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getAll();

	public ProductDto get(Long id);

	public ProductDto save(ProductDto product);

	public ProductDto update(ProductDto product, Long id);

	public void delete(Long id);

	public CategoryDto getCategoryByProductId(Long id);
}
