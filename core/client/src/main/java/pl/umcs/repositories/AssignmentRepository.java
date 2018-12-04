package pl.umcs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.umcs.datatypes.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {


}
