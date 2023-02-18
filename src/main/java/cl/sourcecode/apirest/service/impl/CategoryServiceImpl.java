package cl.sourcecode.apirest.service.impl;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.entity.CategoryEntity;
import cl.sourcecode.apirest.repository.CategoryRepository;
import cl.sourcecode.apirest.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        return categoryEntityList.stream().map(categoryEntity ->
                new CategoryDto(categoryEntity.getId(), categoryEntity.getName())).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        return new CategoryDto(categoryEntity.getId(), categoryEntity.getName());
    }

    @Override
    public CategoryDto saveCategory(CategoryDto category) {
        CategoryEntity categoryEntity = categoryRepository.save(new CategoryEntity(null, category.getName(), new ArrayList<>()));
        return new CategoryDto(categoryEntity.getId(), categoryEntity.getName());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category, Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryEntity.setName(category.getName());
        CategoryEntity updatedCategoryEntity = categoryRepository.save(categoryEntity);
        return new CategoryDto(updatedCategoryEntity.getId(), updatedCategoryEntity.getName());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
