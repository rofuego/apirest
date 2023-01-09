package cl.sourcecode.apirest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public ResponseEntity<TagDto> save(@RequestBody TagDto tag) {
		return new ResponseEntity<>(tagService.save(tag), HttpStatus.CREATED);
	}
}
