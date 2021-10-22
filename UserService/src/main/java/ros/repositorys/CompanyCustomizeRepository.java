package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.CompanyCustomize;

@Repository
public interface CompanyCustomizeRepository  extends JpaRepository<CompanyCustomize, Long>{

}
