package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ros.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
