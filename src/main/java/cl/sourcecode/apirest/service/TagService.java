package cl.sourcecode.apirest.service;

import cl.sourcecode.apirest.dto.TagDto;

import java.util.List;

public interface TagService {

    public List<TagDto> getAllTags();

    public TagDto getTag(Long id);

    public TagDto saveTag(TagDto tag);

    public TagDto updateTag(TagDto tag, Long id);

    public void deleteTag(Long id);
}
