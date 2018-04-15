package io.zipcoder.repositories;

import io.zipcoder.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Iterable<Account> findAllAccountsByCustomerId(Long customerId);
}
