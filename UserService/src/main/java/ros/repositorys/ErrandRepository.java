package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Errand;

@Repository
public interface ErrandRepository  extends JpaRepository<Errand, Long>{

}
