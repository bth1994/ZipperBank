package io.zipcoder.repositories;

import io.zipcoder.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepo extends JpaRepository<Deposit, Long> {
}
