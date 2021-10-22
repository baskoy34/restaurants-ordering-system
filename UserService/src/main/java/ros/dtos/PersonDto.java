package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

	private long id;

	private String name;

	private String surname;

	private String address;

	private String phone;

	private String email;

	private Integer salary;



}
