package cl.sourcecode.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import cl.sourcecode.apirest.entity.TagEntity;

public interface TagRepository extends CrudRepository<TagEntity, Long> {

}
