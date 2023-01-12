package cl.sourcecode.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
public class InvoiceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long folio;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private Double total;

	@Column(nullable = false)
	private String description;

	@ManyToOne()
	@JoinColumn(name = "client_id")
	private ClientEntity client;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<ItemEntity> items;

}
