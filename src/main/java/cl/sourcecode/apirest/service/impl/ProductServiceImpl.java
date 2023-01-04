package cl.sourcecode.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.entity.ProductEntity;
import cl.sourcecode.apirest.repository.ProductRepository;
import cl.sourcecode.apirest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;

	private final ModelMapper mapper;

	public ProductServiceImpl(ProductRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<ProductDto> getAll() {
		Iterable<ProductEntity> iterable = repository.findAll();
		List<ProductDto> list = new ArrayList<>();
		for (ProductEntity entity : iterable) {
			list.add(mapper.map(entity, ProductDto.class));
		}
		return list;
	}

	@Override
	public ProductDto get(Long id) {
		return mapper.map(repository.findById(id).get(), ProductDto.class);
	}

	@Override
	public ProductDto save(ProductDto product) {
		ProductEntity saved = repository.save(mapper.map(product, ProductEntity.class));
		return mapper.map(repository.findById(saved.getId()).get(), ProductDto.class);
	}

	@Override
	public ProductDto update(ProductDto product, Long id) {
		ProductEntity entity = mapper.map(product, ProductEntity.class);
		entity.setId(id);
		return mapper.map(repository.findById(entity.getId()).get(), ProductDto.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

}
