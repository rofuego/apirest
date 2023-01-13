package cl.sourcecode.apirest.dto;

import java.util.Date;
import java.util.List;

import cl.sourcecode.apirest.entity.ClientEntity;
import cl.sourcecode.apirest.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

	private Long id;

	private Long folio;

	private Date date;

	private Double total;

	private String description;

	private ClientEntity client;

	private List<ItemEntity> items;
}
