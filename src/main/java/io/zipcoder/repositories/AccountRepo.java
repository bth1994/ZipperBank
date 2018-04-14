package io.zipcoder.repositories;

import io.zipcoder.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
