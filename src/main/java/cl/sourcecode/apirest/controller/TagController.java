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

import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping
	public ResponseEntity<List<TagDto>> getAll() {
		return new ResponseEntity<>(tagService.getAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<TagDto> get(@PathVariable Long id) {
		return new ResponseEntity<>(tagService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TagDto> save(@RequestBody TagDto tag) {
		return new ResponseEntity<>(tagService.save(tag), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TagDto> update(@PathVariable Long id, @RequestBody TagDto tag) {
		return new ResponseEntity<>(tagService.update(tag, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tagService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
