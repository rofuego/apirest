package cl.sourcecode.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import cl.sourcecode.apirest.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
