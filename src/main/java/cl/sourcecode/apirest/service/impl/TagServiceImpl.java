package cl.sourcecode.apirest.service.impl;

import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.entity.TagEntity;
import cl.sourcecode.apirest.repository.TagRepository;
import cl.sourcecode.apirest.service.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagDto> getAllTags() {
        List<TagEntity> tagEntityList = (List<TagEntity>) tagRepository.findAll();
        return tagEntityList.stream().map(tagEntity ->
                new TagDto(tagEntity.getId(), tagEntity.getName())).collect(Collectors.toList());
    }

    @Override
    public TagDto getTag(Long id) {
        TagEntity tagEntity = tagRepository.findById(id).get();
        return new TagDto(tagEntity.getId(), tagEntity.getName());
    }

    @Override
    public TagDto saveTag(TagDto tag) {
        TagEntity tagEntity = tagRepository.save(new TagEntity(null, tag.getName(), new ArrayList<>()));
        return new TagDto(tagEntity.getId(), tagEntity.getName());
    }

    @Override
    public TagDto updateTag(TagDto tag, Long id) {
        TagEntity tagEntity = tagRepository.findById(id).get();
        tagEntity.setName(tag.getName());
        TagEntity updateTagEntity = tagRepository.save(tagEntity);
        return new TagDto(updateTagEntity.getId(), updateTagEntity.getName());
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
