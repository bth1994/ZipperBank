package io.zipcoder.repositories;

import io.zipcoder.entities.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
<<<<<<< HEAD
    Iterable<Withdrawal> getAllWithdrawalsFromAccId(Long accountId);
    Iterable<Withdrawal> getAllWithdrawalsFromWthDrawId(Long withdrawalId);
=======

    Iterable<Withdrawal> findByAccountId(Long accountId);

    Withdrawal findByAccount(Long withdrawalId);
>>>>>>> 62ad35effbbf2cb42e4a4644af92f88e2b2ba57b
}
