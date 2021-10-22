package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrandDto {

	private long id;

	private Boolean active;

	private Boolean paymentstatus;

	private Boolean orderstatus;

	private BasketDto basket;

	private DeskDto desk;
}
