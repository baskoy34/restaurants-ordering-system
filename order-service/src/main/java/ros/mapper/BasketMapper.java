package ros.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ProductDto;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    @Mappings({
            @Mapping(target = "product" ,source ="product"),
            @Mapping(target = "basketId",source = "basket.id")
    })
    BasketProductDto toBasketProductDto(BasketProduct basketProduct);

    @Mappings({
            @Mapping(target = "image" ,source ="image"),

    })
    ProductDto productToProductdto(Product product);

    @Mappings({
            @Mapping(target ="basketProducts",source = "basketProducts")
    })
    BasketDto basketToBasketDto(Basket basket);


}
