package cl.sourcecode.apirest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

	private Long id;

	private String address;

	private List<String> phones;

	private String email;
}
