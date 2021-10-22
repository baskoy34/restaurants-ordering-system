package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Desk;

import java.util.List;

@Repository
public interface DeskRepository  extends JpaRepository<Desk, Long>{

    List<Desk> findAllByStore(Long id);

}
