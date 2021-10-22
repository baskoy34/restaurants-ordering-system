package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ros.models.BasketProduct;

import java.util.Optional;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long>{

    @Transactional
    @Modifying
    void deleteBasketProductByBasket_IdAndProductId(Long basketId,Long productId);

   BasketProduct findByBasket_IdAndProductId(Long basketId, Long productId);

}
