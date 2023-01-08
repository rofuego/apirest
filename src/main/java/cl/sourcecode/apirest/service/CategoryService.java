package cl.sourcecode.apirest.service;

import java.util.List;

import cl.sourcecode.apirest.dto.CategoryDto;

public interface CategoryService {

	public List<CategoryDto> getAll();

	public CategoryDto get(Long id);

	public CategoryDto save(CategoryDto category);

	public CategoryDto update(CategoryDto category, Long id);

	public void delete(Long id);

	public CategoryDto getCategoryByProduct(Long id);
}
