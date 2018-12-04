package pl.umcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.umcs.datatypes.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}


