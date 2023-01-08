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
import cl.sourcecode.apirest.service.CategoryService;
import cl.sourcecode.apirest.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;

	private final CategoryService categoryService;

	public ProductController(ProductService service, CategoryService categoryService) {
		this.service = service;
		this.categoryService = categoryService;
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto product) {
		return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto product, @PathVariable Long id) {
		return new ResponseEntity<>(service.update(product, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("{id}/category")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
		return new ResponseEntity<>(categoryService.getCategoryByProduct(id), HttpStatus.OK);
	}
}
