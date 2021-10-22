package ros.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ros.dtos.BasketProductDto;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;
import ros.repositorys.BasketRepository;
import ros.repositorys.ProductRepository;
import ros.services.BasketServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BasketProductMapper {
    @Autowired
    private BasketServiceImpl basketService;
    @Autowired
    private ProductRepository productRepository;


    @Mappings({
            @Mapping(target = "product", source = "product.id", qualifiedByName = "toProduct"),
            @Mapping(target = "basket", source = "basketId",qualifiedByName = "toBasket"),
            @Mapping(target = "id", ignore = true)
    })
    public abstract BasketProduct dtoToBasketProduct(BasketProductDto basketProductDto);



        @Named("toProduct")
        public Product toProduct(Long productId) throws EntityNotFoundException {
            System.out.println("to product girdi");
                return productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        }
        @Named("toBasket")
        public Basket toBasket(Long basketId) throws EntityNotFoundException {
            System.out.println("to basket girdi");
            return basketService.findById(basketId).orElseThrow(EntityNotFoundException::new);


//    @Named("fromLongToTypeReport")
//    public Product fromLongToTypeReport(long basketId) throws EntityNotFoundException {
//        return typeReportService.findById(groupParameterIdDTO.getTypeReportId());
//    }
    }
}
