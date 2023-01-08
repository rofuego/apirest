package cl.sourcecode.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.entity.CategoryEntity;
import cl.sourcecode.apirest.repository.CategoryRepository;
import cl.sourcecode.apirest.repository.ProductRepository;
import cl.sourcecode.apirest.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repository;

	private final ProductRepository productRepository;

	private final ModelMapper mapper;

	public CategoryServiceImpl(CategoryRepository repository, ProductRepository productRepository, ModelMapper mapper) {
		this.repository = repository;
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public List<CategoryDto> getAll() {
		Iterable<CategoryEntity> iterable = repository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		for (CategoryEntity entity : iterable) {
			list.add(mapper.map(entity, CategoryDto.class));
		}
		return list;
	}

	@Override
	public CategoryDto get(Long id) {
		return mapper.map(repository.findById(id).get(), CategoryDto.class);
	}

	@Override
	public CategoryDto save(CategoryDto category) {
		CategoryEntity entity = repository.save(mapper.map(category, CategoryEntity.class));
		return mapper.map(repository.findById(entity.getId()).get(), CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto category, Long id) {
		CategoryEntity entity = mapper.map(category, CategoryEntity.class);
		entity.setId(id);
		return mapper.map(repository.findById(entity.getId()).get(), CategoryDto.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public CategoryDto getCategoryByProduct(Long id) {
		return mapper.map(productRepository.findById(id).get().getCategory(), CategoryDto.class);
	}

}
