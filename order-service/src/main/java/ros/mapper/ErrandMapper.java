package ros.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ros.dtos.ErrandDto;
import ros.dtos.ProductDto;
import ros.models.Errand;
import ros.models.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ErrandMapper {
    @Mappings({
            @Mapping(target = "basket",source = "basket"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "desk", ignore = true)
    })
    Errand dtoToErrand(ErrandDto errandDto);

    List<ErrandDto> errandToDtoList(List<Errand> errands);

    ProductDto productToProductdto(Product product);
    @Mappings({
            @Mapping(target = "basket.basketProducts",source = "basket.basketProducts" ,qualifiedByName="BasketProductMapper.dtoToBasketProduct"),
    })
    ErrandDto modelToErrandDto(Errand errand);
}
