package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ros.bus.OrderEvent;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;
import ros.dtos.ErrandDto;
import ros.models.Product;
import ros.repositorys.ProductRepository;
import ros.request.BasketItem;
import ros.response.AddtoCartResponse;
import ros.services.BasketServiceImpl;
import ros.services.OrderServiceImpl;

import java.util.List;

@RequestMapping("/basket")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BasketApi {
  private final OrderEvent orderEvent;
  private final   BasketServiceImpl basketService;
  private final ProductRepository productRepository;
  private final OrderServiceImpl orderService;

    @PostMapping
  public ResponseEntity<AddtoCartResponse>addToBasket(@RequestBody BasketProductDto basketProductDto){
        AddtoCartResponse cartResponse =null;
      try {
          cartResponse = basketService.addtoBasket(basketProductDto);
          orderEvent.orderCreated(1L,basketProductDto);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return ResponseEntity.ok(cartResponse);
  }
  @GetMapping("/item")
  public ResponseEntity<List<Product>>getItems(){
      return ResponseEntity.ok(productRepository.findAll());
  }

    @GetMapping
  public  ResponseEntity<BasketDto>getBasket(){
        return ResponseEntity.ok(basketService.getBasket(1L));
  }

    @PostMapping("/removeItem")
    public ResponseEntity<BasketDto>removeBasketItem(@RequestBody BasketItem basketItem){
        BasketDto cartResponse =null;
        try {
           cartResponse=basketService.deleteBasketProductItem(basketItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(cartResponse);
    }

    @PostMapping("/updateQuentityItem")
    public ResponseEntity<BasketDto>increaseBasketItem(@RequestBody BasketItem basketItem){
        BasketDto cartResponse =null;
        try {
            cartResponse=basketService.updateQuentityBasketProductItem(basketItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(cartResponse);
    }

    @PostMapping("/Order")
    public  ResponseEntity<ErrandDto> postOrder(@RequestBody ErrandDto errandDto){
        ErrandDto errand= orderService.postOrder(errandDto);
        return ResponseEntity.ok(errand);
    }

    @GetMapping("/Order")
    public  ResponseEntity<List<ErrandDto>> getOrders(long deskId){
        //orderService.getOrder(orderId);
        return ResponseEntity.ok(orderService.getOrders(deskId));
    }

}
