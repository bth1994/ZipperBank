package io.zipcoder.services;

import io.zipcoder.entities.Withdrawal;
import io.zipcoder.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    private WithdrawalRepo withdrawalRepo;

    @Autowired
    public WithdrawalService(WithdrawalRepo withdrawalRepo){
        this.withdrawalRepo = withdrawalRepo;
    }
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsFromAccountId(Long accountId){
        return null;
    }
    public ResponseEntity<Iterable<Withdrawal>> getWithdrawalsByWithdrawalId(Long withdrawalId){
        return null;
    }
    public ResponseEntity<Withdrawal> createWithdrawal(Long accountId, Withdrawal withdrawal){
        return null;
    }
    public ResponseEntity<Withdrawal> updateWithdrawal(Long withdrawalId, Withdrawal withdrawal){
        return null;
    }
    public ResponseEntity deleteWithdrawal(Long withdrawalId){
        return null;
    }
}
