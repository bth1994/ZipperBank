package io.zipcoder.services;

import io.zipcoder.entities.Withdrawal;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WithdrawalService {

    private WithdrawalRepo withdrawalRepo;
    private AccountRepo accountRepo;


    @Autowired
    public WithdrawalService(WithdrawalRepo withdrawalRepo, AccountRepo accountRepo){
        this.withdrawalRepo = withdrawalRepo;
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsFromAccountId(Long accountId) {
        return new ResponseEntity<>(withdrawalRepo.findByAccountId(accountId), HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> getWithdrawalsByWithdrawalId(Long withdrawalId) {
        return new ResponseEntity<>(withdrawalRepo.findOne(withdrawalId), HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> createWithdrawal(Long accountId, Withdrawal withdrawal) {
        withdrawal.setAccount(accountRepo.findOne(accountId));
        Withdrawal newWithdrawal = withdrawalRepo.save(withdrawal);
        return new ResponseEntity<>(newWithdrawal, HttpStatus.CREATED);
    }

    public ResponseEntity<Withdrawal> updateWithdrawal(Long withdrawalId, Withdrawal withdrawal) {
        withdrawal.setId(withdrawalId);
        Withdrawal newWithdrawal = withdrawalRepo.save(withdrawal);
        return new ResponseEntity<>(newWithdrawal, HttpStatus.OK);
    }

    public ResponseEntity deleteWithdrawal(Long withdrawalId) {
        withdrawalRepo.delete(withdrawalId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
