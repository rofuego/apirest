package cl.sourcecode.apirest.controller;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto product, @PathVariable Long id) {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("{id}/category")
    public ResponseEntity<CategoryDto> getCategoryByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getCategoryByProductId(id), HttpStatus.OK);
    }

    @GetMapping("{id}/tags")
    public ResponseEntity<List<TagDto>> getAllTagsByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getAllTagsByProductId(id), HttpStatus.OK);
    }

}
