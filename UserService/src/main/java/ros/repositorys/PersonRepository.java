package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long>{

}
