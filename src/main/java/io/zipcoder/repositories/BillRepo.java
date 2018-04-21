package io.zipcoder.repositories;

import io.zipcoder.entities.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill, Long> {
    Iterable<Bill> findAllBillsByAccountId(Long accountId);

    Iterable<Bill> findAllBillsByCustomerId(Long accountId);


}
