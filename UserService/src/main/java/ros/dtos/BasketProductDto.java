package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketProductDto {

	private long id;

	private Integer piece;

	private ProductDto product;

	private BasketDto basket;
	
}
