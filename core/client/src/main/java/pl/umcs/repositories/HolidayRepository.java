package pl.umcs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.umcs.datatypes.Holiday;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {


}