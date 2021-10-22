package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

    List<Category> findAllByStore(Long id);

}
