package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

	private long id;

	private String name;

	private String address;

	private String phone;

	private Boolean active;

	private long companyId;

	private List<DeskDto> desks;

	private List<CategoryDto> categoryies;

	private List<UserDto> users;
}
