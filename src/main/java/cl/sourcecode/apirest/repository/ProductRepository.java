package cl.sourcecode.apirest.repository;

import cl.sourcecode.apirest.entity.CategoryEntity;
import cl.sourcecode.apirest.entity.ProductEntity;
import cl.sourcecode.apirest.entity.TagEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT p.category FROM ProductEntity p WHERE p.id = :productId")
    CategoryEntity findCategoryByProductId(@Param("productId") Long productId);

    @Query("SELECT p.tags FROM ProductEntity p WHERE p.id = :productId")
    List<TagEntity> findTagsByProductId(@Param("productId") Long productId);
}
