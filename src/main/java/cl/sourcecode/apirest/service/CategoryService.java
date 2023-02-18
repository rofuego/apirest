package cl.sourcecode.apirest.service;

import cl.sourcecode.apirest.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    public List<CategoryDto> getAllCategories();

    public CategoryDto getCategory(Long id);

    public CategoryDto saveCategory(CategoryDto category);

    public CategoryDto updateCategory(CategoryDto category, Long id);

    public void deleteCategory(Long id);
}
