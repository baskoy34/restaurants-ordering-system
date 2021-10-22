package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ros.models.Errand;

import java.util.List;

@Repository
public interface ErrandRepository  extends JpaRepository<Errand, Long>{
List<Errand> findByDesk_Id(long deskId);
}
