package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ros.models.OrderStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrandDto {

	private long id;

	private Boolean active;

	private Boolean paymentstatus;

	private OrderStatus orderstatus;

	private BasketDto basket;

}
