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

<<<<<<< HEAD
    Withdrawal findByAccount(Long withdrawalId);
>>>>>>> 62ad35effbbf2cb42e4a4644af92f88e2b2ba57b
=======

>>>>>>> 59dba2fec2f89e74988a1b841808219bd2bcf7d7
}
