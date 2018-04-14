package io.zipcoder.repositories;

import io.zipcoder.entities.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
    Iterable<Withdrawal> getAllWithdrawalsFromAccId(Long accountId);
    Iterable<Withdrawal> getAllWithdrawalsFromWthDrawId(Long withdrawalId);
}
