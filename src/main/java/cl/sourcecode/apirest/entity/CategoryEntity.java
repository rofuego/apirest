package cl.sourcecode.apirest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "category")
	private List<ProductEntity> producs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductEntity> getProducs() {
		return producs;
	}

	public void setProducs(List<ProductEntity> producs) {
		this.producs = producs;
	}

	public CategoryEntity(Long id, String name, String description, List<ProductEntity> producs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.producs = producs;
	}

	public CategoryEntity() {
		super();
	}

}
