package cl.sourcecode.apirest.service;

import java.util.List;

import cl.sourcecode.apirest.dto.TagDto;

public interface TagService {

	public List<TagDto> getAll();

	public TagDto get(Long id);

	public TagDto save(TagDto tag);

	public TagDto update(TagDto tag, Long id);

	public void delete(Long id);
}
