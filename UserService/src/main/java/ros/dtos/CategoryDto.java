package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private long id;

	private String name;

	private boolean active;

	private StoreDto store;

	private List<ProductDto> products;
	
}
