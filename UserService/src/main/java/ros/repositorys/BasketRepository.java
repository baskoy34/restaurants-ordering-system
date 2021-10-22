package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Basket;

@Repository
public interface BasketRepository  extends JpaRepository<Basket, Long>{

}
