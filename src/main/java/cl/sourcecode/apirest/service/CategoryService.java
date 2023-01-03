package cl.sourcecode.apirest.service;

import cl.sourcecode.apirest.dto.CategoryRequestDto;
import cl.sourcecode.apirest.dto.CategoryResponseDto;

public interface CategoryService {

	public Iterable<CategoryResponseDto> getAll();

	public CategoryResponseDto get(Long id);

	public CategoryResponseDto save(CategoryRequestDto category);

	public void delete(Long id);
}
