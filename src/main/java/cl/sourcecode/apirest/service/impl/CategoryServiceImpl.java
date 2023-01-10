package cl.sourcecode.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.entity.CategoryEntity;
import cl.sourcecode.apirest.repository.CategoryRepository;
import cl.sourcecode.apirest.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	private final ModelMapper mapper;

	public CategoryServiceImpl(CategoryRepository repository, ModelMapper mapper) {
		this.categoryRepository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<CategoryDto> getAll() {
		Iterable<CategoryEntity> iterable = categoryRepository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		for (CategoryEntity entity : iterable) {
			list.add(mapper.map(entity, CategoryDto.class));
		}
		return list;
	}

	@Override
	public CategoryDto get(Long id) {
		return mapper.map(categoryRepository.findById(id).get(), CategoryDto.class);
	}

	@Override
	public CategoryDto save(CategoryDto category) {
		return mapper.map(categoryRepository.save(mapper.map(category, CategoryEntity.class)), CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto category, Long id) {
		category.setId(id);
		return mapper.map(categoryRepository.save(mapper.map(category, CategoryEntity.class)), CategoryDto.class);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}
