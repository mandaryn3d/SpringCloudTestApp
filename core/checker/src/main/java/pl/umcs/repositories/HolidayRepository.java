package pl.umcs.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.umcs.datatypes.Holiday;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {


}