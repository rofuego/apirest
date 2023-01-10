package cl.sourcecode.apirest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.sourcecode.apirest.dto.CategoryDto;
import cl.sourcecode.apirest.dto.ProductDto;
import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable Long id) {
		return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto product, @PathVariable Long id) {
		return new ResponseEntity<>(productService.update(product, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("{id}/category")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
		return new ResponseEntity<>(productService.getCategoryByProductId(id), HttpStatus.OK);
	}

	@GetMapping("{id}/tags")
	public ResponseEntity<List<TagDto>> getTagsByProduct(@PathVariable Long id) {
		return new ResponseEntity<>(productService.getTagsByProductId(id), HttpStatus.OK);
	}

}
