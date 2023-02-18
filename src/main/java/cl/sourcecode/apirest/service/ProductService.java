package cl.sourcecode.apirest.service;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.dto.TagDto;

import java.util.List;

public interface ProductService {

    public List<ProductDto> getAllProducts();

    public ProductDto getProduct(Long id);

    public ProductDto saveProduct(ProductDto product);

    public ProductDto updateProduct(ProductDto product, Long id);

    public void deleteProduct(Long id);

    public CategoryDto getCategoryByProductId(Long id);

    public List<TagDto> getAllTagsByProductId(Long id);

}
