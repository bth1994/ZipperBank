package io.zipcoder.repositories;

import io.zipcoder.entities.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill, Long> {
}
