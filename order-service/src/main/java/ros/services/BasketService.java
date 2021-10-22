package ros.services;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ProductDto;
import ros.models.Product;
import ros.response.AddtoCartResponse;

public interface BasketService {
    BasketDto getBasket(Long id);
    AddtoCartResponse addtoBasket(BasketProductDto basketProductDto) throws Exception;
    BasketDto removeBasketsItem(Long basketId,long productid);
    BasketDto clearBasket(Long basketId);

}
