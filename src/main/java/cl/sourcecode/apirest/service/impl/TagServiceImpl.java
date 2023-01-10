package cl.sourcecode.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import cl.sourcecode.apirest.dto.TagDto;
import cl.sourcecode.apirest.entity.TagEntity;
import cl.sourcecode.apirest.repository.TagRepository;
import cl.sourcecode.apirest.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;

	private final ModelMapper mapper;

	public TagServiceImpl(TagRepository tagRepository, ModelMapper mapper) {
		this.tagRepository = tagRepository;
		this.mapper = mapper;
	}

	@Override
	public List<TagDto> getAll() {
		Iterable<TagEntity> iterable = tagRepository.findAll();
		List<TagDto> list = new ArrayList<>();
		for (TagEntity entity : iterable) {
			list.add(mapper.map(entity, TagDto.class));
		}
		return list;
	}

	@Override
	public TagDto get(Long id) {
		return mapper.map(tagRepository.findById(id).get(), TagDto.class);
	}

	@Override
	public TagDto save(TagDto tag) {
		return mapper.map(tagRepository.save(mapper.map(tag, TagEntity.class)), TagDto.class);
	}

	@Override
	public TagDto update(TagDto tag, Long id) {
		tag.setId(id);
		return mapper.map(tagRepository.save(mapper.map(tag, TagEntity.class)), TagDto.class);
	}

	@Override
	public void delete(Long id) {
		tagRepository.deleteById(id);
	}
}
