package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private long id;

	private String name;

	private String information;

	private String image;

	private double price;

	private double vat;

	private boolean active;

	private CategoryDto category;

	private List<BasketProductDto> basketProducts;
}
