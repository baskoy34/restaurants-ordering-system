package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long id;

	private String username;

	private String password;

	private Boolean active;

	private PersonDto person;

	private List<RoleDto> roles;

	private StoreDto store;
	
}
