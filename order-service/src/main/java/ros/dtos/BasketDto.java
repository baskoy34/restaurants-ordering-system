package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {

	private long id;

	private double totalPrice;

	private double totalVat;
	private int totalItem;

	private List<BasketProductDto> basketProducts;
	
}
