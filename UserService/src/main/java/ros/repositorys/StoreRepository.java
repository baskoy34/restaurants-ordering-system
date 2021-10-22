package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Store;

import java.util.List;

@Repository
public interface StoreRepository  extends JpaRepository<Store, Long>{

    List<Store> findByCompany(Long id);

}
