package io.zipcoder.repositories;

import io.zipcoder.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepo extends CrudRepository<Deposit, Long> {
    Iterable<Deposit> findByAccountId(Long accountId);
}
