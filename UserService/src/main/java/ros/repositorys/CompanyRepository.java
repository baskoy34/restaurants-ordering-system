package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ros.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
