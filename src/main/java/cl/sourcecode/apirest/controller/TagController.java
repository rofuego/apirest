package cl.sourcecode.apirest.controller;

import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TagDto> getTag(@PathVariable Long id) {
        return new ResponseEntity<>(tagService.getTag(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TagDto> saveTag(@RequestBody TagDto tag) {
        return new ResponseEntity<>(tagService.saveTag(tag), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDto> updateTag(@PathVariable Long id, @RequestBody TagDto tag) {
        return new ResponseEntity<>(tagService.updateTag(tag, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
