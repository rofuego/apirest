package cl.sourcecode.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.entity.CategoryEntity;
import cl.sourcecode.apirest.entity.ProductEntity;
import cl.sourcecode.apirest.entity.TagEntity;
import cl.sourcecode.apirest.repository.CategoryRepository;
import cl.sourcecode.apirest.repository.ProductRepository;
import cl.sourcecode.apirest.repository.TagRepository;
import cl.sourcecode.apirest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	private final CategoryRepository categoryRepository;

	private final TagRepository tagRepository;

	private final ModelMapper mapper;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
			TagRepository tagRepository, ModelMapper mapper) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.tagRepository = tagRepository;
		this.mapper = mapper;
	}

	@Override
	public List<ProductDto> getAll() {
		Iterable<ProductEntity> iterable = productRepository.findAll();
		List<ProductDto> list = new ArrayList<>();
		for (ProductEntity entity : iterable) {
			list.add(mapper.map(entity, ProductDto.class));
		}
		return list;
	}

	@Override
	public ProductDto get(Long id) {
		return mapper.map(productRepository.findById(id).get(), ProductDto.class);
	}

	@Override
	public ProductDto save(ProductDto product) {
		ProductEntity entity = new ProductEntity();
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setQuantity(product.getQuantity());
		CategoryEntity category = categoryRepository.findById(product.getCategory().getId()).get();
		entity.setCategory(category);
		List<TagEntity> tags = new ArrayList<>();
		for (TagDto tag : product.getTags()) {
			tags.add(tagRepository.findById(tag.getId()).get());
		}
		entity.setTags(tags);
		ProductEntity saved = productRepository.save(entity);
		return mapper.map(productRepository.findById(saved.getId()).get(), ProductDto.class);
	}

	@Override
	public ProductDto update(ProductDto product, Long id) {
		ProductEntity entity = mapper.map(product, ProductEntity.class);
		entity.setId(id);
		return mapper.map(productRepository.findById(entity.getId()).get(), ProductDto.class);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public CategoryDto getCategoryByProductId(Long id) {
		return mapper.map(productRepository.findById(id).get().getCategory(), CategoryDto.class);
	}
}
