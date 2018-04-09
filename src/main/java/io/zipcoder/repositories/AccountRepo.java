package io.zipcoder.repositories;

import io.zipcoder.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long>{
}
