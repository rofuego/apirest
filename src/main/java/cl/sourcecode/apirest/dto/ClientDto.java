package cl.sourcecode.apirest.dto;

import cl.sourcecode.apirest.entity.ContactEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private Long id;

	private String name;

	private String dni;

	private ContactEntity contact;
}
