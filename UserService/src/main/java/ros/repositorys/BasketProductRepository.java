package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.BasketProduct;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long>{

}
