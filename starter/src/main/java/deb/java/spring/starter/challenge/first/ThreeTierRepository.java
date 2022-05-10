package deb.java.spring.starter.challenge.first;

import org.springframework.data.repository.CrudRepository;

public interface ThreeTierRepository extends CrudRepository<Employee, Integer> {
}
