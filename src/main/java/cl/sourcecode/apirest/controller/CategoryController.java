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
import cl.sourcecode.apirest.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto category) {
		return new ResponseEntity<>(service.save(category), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto category, @PathVariable Long id) {
		return new ResponseEntity<>(service.update(category, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
