package ros.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ProductDto;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-30T20:58:51+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Override
    public BasketProductDto toBasketProductDto(BasketProduct basketProduct) {
        if ( basketProduct == null ) {
            return null;
        }

        BasketProductDto basketProductDto = new BasketProductDto();

        Long id = basketProductBasketId( basketProduct );
        if ( id != null ) {
            basketProductDto.setBasketId( id );
        }
        basketProductDto.setProduct( productToProductdto( basketProduct.getProduct() ) );
        basketProductDto.setId( basketProduct.getId() );
        basketProductDto.setPiece( basketProduct.getPiece() );

        return basketProductDto;
    }

    @Override
    public ProductDto productToProductdto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setImage( product.getImage() );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setInformation( product.getInformation() );
        productDto.setPrice( product.getPrice() );
        productDto.setVat( product.getVat() );
        productDto.setCategory( product.getCategory() );

        return productDto;
    }

    @Override
    public BasketDto basketToBasketDto(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        BasketDto basketDto = new BasketDto();

        basketDto.setBasketProducts( basketProductListToBasketProductDtoList( basket.getBasketProducts() ) );
        basketDto.setId( basket.getId() );
        basketDto.setTotalPrice( basket.getTotalPrice() );
        basketDto.setTotalVat( basket.getTotalVat() );
        basketDto.setTotalItem( basket.getTotalItem() );

        return basketDto;
    }

    private Long basketProductBasketId(BasketProduct basketProduct) {
        if ( basketProduct == null ) {
            return null;
        }
        Basket basket = basketProduct.getBasket();
        if ( basket == null ) {
            return null;
        }
        long id = basket.getId();
        return id;
    }

    protected List<BasketProductDto> basketProductListToBasketProductDtoList(List<BasketProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<BasketProductDto> list1 = new ArrayList<BasketProductDto>( list.size() );
        for ( BasketProduct basketProduct : list ) {
            list1.add( toBasketProductDto( basketProduct ) );
        }

        return list1;
    }
}
