package io.zipcoder.repositories;

import io.zipcoder.entities.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepo extends JpaRepository<Withdrawal, Long>{
}
