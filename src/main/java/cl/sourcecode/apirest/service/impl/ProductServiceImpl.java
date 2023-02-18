package cl.sourcecode.apirest.service.impl;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.entity.ProductEntity;
import cl.sourcecode.apirest.entity.TagEntity;
import cl.sourcecode.apirest.repository.CategoryRepository;
import cl.sourcecode.apirest.repository.ProductRepository;
import cl.sourcecode.apirest.repository.TagRepository;
import cl.sourcecode.apirest.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final TagRepository tagRepository;

    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                              TagRepository tagRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        return productEntityList.stream().map(productEntity -> modelMapper.map(productEntity, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(Long id) {
        return modelMapper.map(productRepository.findById(id).get(), ProductDto.class);
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productEntity.setCategory(categoryRepository.findById(product.getCategory().getId()).get());
        List<TagEntity> tags = new ArrayList<>();
        for (TagDto tag : product.getTags()) {
            tags.add(tagRepository.findById(tag.getId()).get());
        }
        productEntity.setTags(tags);
        return modelMapper.map(productRepository.save(productEntity), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto product, Long id) {
        ProductEntity entity = modelMapper.map(product, ProductEntity.class);
        entity.setId(id);
        entity.setCategory(categoryRepository.findById(product.getCategory().getId()).get());
        List<TagEntity> tags = new ArrayList<>();
        for (TagDto tag : product.getTags()) {
            tags.add(tagRepository.findById(tag.getId()).get());
        }
        entity.setTags(tags);
        return modelMapper.map(productRepository.save(entity), ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public CategoryDto getCategoryByProductId(Long id) {
        return modelMapper.map(productRepository.findCategoryByProductId(id), CategoryDto.class);
    }

    @Override
    public List<TagDto> getAllTagsByProductId(Long id) {
        return productRepository.findTagsByProductId(id).stream().map(tagEntity ->
                modelMapper.map(tagEntity, TagDto.class)).collect(Collectors.toList());
    }
}
