package cl.sourcecode.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import cl.sourcecode.apirest.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

}
