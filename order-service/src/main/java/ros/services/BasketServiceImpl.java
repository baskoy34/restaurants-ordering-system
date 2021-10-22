package ros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.mapper.BasketMapper;
import ros.mapper.BasketProductMapper;
import ros.mapper.ProductMapper;
import ros.models.Basket;
import ros.models.BasketProduct;
import ros.models.Product;
import ros.repositorys.BasketProductRepository;
import ros.repositorys.BasketRepository;
import ros.repositorys.ProductRepository;
import ros.request.BasketItem;
import ros.response.AddtoCartResponse;

import java.util.Optional;

@Service

public class BasketServiceImpl implements BasketService {
  private ProductMapper productMapper;
  @Autowired
  private BasketMapper basketMapper;
  @Autowired
  private BasketProductMapper basketProductMapper;
  @Autowired
  private   BasketRepository basketRepository;
  @Autowired
  private  ProductRepository productRepository;
  @Autowired
  private   BasketProductRepository basketProductRepository;



    @Override
    public BasketDto getBasket(Long id) {
        //desk client çağır
        Basket basket=basketRepository.findById(id).get();
        return basketMapper.basketToBasketDto(basket);
    }
    public Optional<Basket>findById(Long id){
        return basketRepository.findById(id);
    }

    @Override
    public AddtoCartResponse addtoBasket(BasketProductDto basketProductDto) throws Exception {

        Basket basket=basketRepository.findById(basketProductDto.getBasketId()).orElseThrow(Exception::new);
        Product product=productRepository.findById(basketProductDto.getProduct().getId()).orElseThrow(Exception::new);

        //basket.setTotalPrice(basket.getTotalPrice()+product.getPrice());
        //call stock service if quantiy  ok
        //check item in basket ?

        BasketProduct basketProduct=basketProductRepository.findByBasket_IdAndProductId(basketProductDto.getBasketId(),basketProductDto.getProduct().getId());
        if(basketProduct==null){
            basketProduct= new BasketProduct(basketProductDto.getPiece(),product,basket);
        }
        else {
            basketProduct.setPiece(basketProduct.getPiece()+1);
        }
        basketProductRepository.save(basketProduct);
        // remove gelince sil
        basket=updateBasket(basket);
        basket=basketRepository.save(basket);
        AddtoCartResponse response =new AddtoCartResponse();
        response.setBasketId(basket.getId());
        response.setItemCount(basket.getTotalItem());
        response.setTotalPrice(basket.getTotalPrice());
        return response;
    }

    @Override
    public BasketDto removeBasketsItem(Long basketId, long productid) {
        return null;
    }

    @Override
    public BasketDto clearBasket(Long basketId) {
        return null;
    }

    public  Basket updateBasket(Basket basket){
        if (basket.getBasketProducts().size()==0) {
            basket.setTotalPrice(0);
            basket.setTotalItem(0);
            return basket;
        }
       else if (basket.getBasketProducts().size()==1) {
            basket.setTotalPrice(basket.getBasketProducts().get(0).getProduct().getPrice() * basket.getBasketProducts().get(0).getPiece());
            basket.setTotalItem(basket.getBasketProducts().get(0).getPiece());
            return basket;
        }
       else {
           basket.setTotalPrice(basket.getBasketProducts().stream().mapToDouble(p-> p.getPiece()*p.getProduct().getPrice()).reduce(0,(y,x)-> y+x ));
           basket.setTotalItem(basket.getBasketProducts().stream().mapToInt(p->p.getPiece()).reduce(0,(x,y)->x+y));
            return basket;
        }

    }

    public BasketDto deleteBasketProductItem(BasketItem basketItem){
        basketProductRepository.deleteBasketProductByBasket_IdAndProductId(basketItem.getBasketid(),basketItem.getProductid());
        Basket basket=basketRepository.findById(basketItem.getBasketid()).get();
        basket=updateBasket(basket);
        basketRepository.save(basket);
        return basketMapper.basketToBasketDto(basket);
    }
    public BasketDto updateQuentityBasketProductItem(BasketItem basketItem){
        BasketProduct basketProduct=basketProductRepository.findByBasket_IdAndProductId(basketItem.getBasketid(),basketItem.getProductid());
        Basket basket=basketRepository.findById(basketItem.getBasketid()).get();
        if(basketItem.getProceses().equalsIgnoreCase("increase")){
            basketProduct.setPiece(basketProduct.getPiece()+1);
        }
        else {
            if(basketProduct.getPiece()==1){
                return deleteBasketProductItem(basketItem);
            }
            basketProduct.setPiece(basketProduct.getPiece()-1);
        }
        basketProductRepository.save(basketProduct);

        basket=updateBasket(basket);
        basketRepository.save(basket);
        return basketMapper.basketToBasketDto(basket);
    }
}
