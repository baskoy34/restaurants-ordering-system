package ros.mapper;

import org.mapstruct.Mapper;
import ros.dtos.ProductDto;
import ros.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto productToProductdto(Product product);
    }

