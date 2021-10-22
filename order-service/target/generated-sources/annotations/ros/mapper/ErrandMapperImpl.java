package ros.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ErrandDto;
import ros.dtos.ProductDto;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Errand;
import ros.models.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-30T17:46:22+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ErrandMapperImpl implements ErrandMapper {

    @Override
    public Errand dtoToErrand(ErrandDto errandDto) {
        if ( errandDto == null ) {
            return null;
        }

        Errand errand = new Errand();

        errand.setBasket( basketDtoToBasket( errandDto.getBasket() ) );
        errand.setActive( errandDto.getActive() );
        errand.setPaymentstatus( errandDto.getPaymentstatus() );
        errand.setOrderstatus( errandDto.getOrderstatus() );

        return errand;
    }

    @Override
    public List<ErrandDto> errandToDtoList(List<Errand> errands) {
        if ( errands == null ) {
            return null;
        }

        List<ErrandDto> list = new ArrayList<ErrandDto>( errands.size() );
        for ( Errand errand : errands ) {
            list.add( modelToErrandDto( errand ) );
        }

        return list;
    }

    @Override
    public ProductDto productToProductdto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setInformation( product.getInformation() );
        productDto.setPrice( product.getPrice() );
        productDto.setImage( product.getImage() );
        productDto.setVat( product.getVat() );
        productDto.setCategory( product.getCategory() );

        return productDto;
    }

    @Override
    public ErrandDto modelToErrandDto(Errand errand) {
        if ( errand == null ) {
            return null;
        }

        ErrandDto errandDto = new ErrandDto();

        errandDto.setBasket( basketToBasketDto( errand.getBasket() ) );
        errandDto.setId( errand.getId() );
        errandDto.setActive( errand.getActive() );
        errandDto.setPaymentstatus( errand.getPaymentstatus() );
        errandDto.setOrderstatus( errand.getOrderstatus() );

        return errandDto;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setInformation( productDto.getInformation() );
        product.setImage( productDto.getImage() );
        product.setPrice( productDto.getPrice() );
        product.setVat( productDto.getVat() );
        product.setCategory( productDto.getCategory() );

        return product;
    }

    protected BasketProduct basketProductDtoToBasketProduct(BasketProductDto basketProductDto) {
        if ( basketProductDto == null ) {
            return null;
        }

        BasketProduct basketProduct = new BasketProduct();

        basketProduct.setId( basketProductDto.getId() );
        basketProduct.setPiece( basketProductDto.getPiece() );
        basketProduct.setProduct( productDtoToProduct( basketProductDto.getProduct() ) );

        return basketProduct;
    }

    protected List<BasketProduct> basketProductDtoListToBasketProductList(List<BasketProductDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BasketProduct> list1 = new ArrayList<BasketProduct>( list.size() );
        for ( BasketProductDto basketProductDto : list ) {
            list1.add( basketProductDtoToBasketProduct( basketProductDto ) );
        }

        return list1;
    }

    protected Basket basketDtoToBasket(BasketDto basketDto) {
        if ( basketDto == null ) {
            return null;
        }

        Basket basket = new Basket();

        basket.setId( basketDto.getId() );
        basket.setTotalPrice( basketDto.getTotalPrice() );
        basket.setTotalVat( basketDto.getTotalVat() );
        basket.setBasketProducts( basketProductDtoListToBasketProductList( basketDto.getBasketProducts() ) );
        basket.setTotalItem( basketDto.getTotalItem() );

        return basket;
    }

    protected BasketProductDto basketProductToBasketProductDto(BasketProduct basketProduct) {
        if ( basketProduct == null ) {
            return null;
        }

        BasketProductDto basketProductDto = new BasketProductDto();

        basketProductDto.setId( basketProduct.getId() );
        basketProductDto.setPiece( basketProduct.getPiece() );
        basketProductDto.setProduct( productToProductdto( basketProduct.getProduct() ) );

        return basketProductDto;
    }

    protected List<BasketProductDto> basketProductListToBasketProductDtoList(List<BasketProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<BasketProductDto> list1 = new ArrayList<BasketProductDto>( list.size() );
        for ( BasketProduct basketProduct : list ) {
            list1.add( basketProductToBasketProductDto( basketProduct ) );
        }

        return list1;
    }

    protected BasketDto basketToBasketDto(Basket basket) {
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
}
