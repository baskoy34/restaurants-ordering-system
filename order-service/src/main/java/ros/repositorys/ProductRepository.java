package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ros.models.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{

}
