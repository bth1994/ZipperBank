package io.zipcoder.services;

import io.zipcoder.entities.Deposit;
import io.zipcoder.repositories.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    private DepositRepo depositRepo;

    @Autowired
    public DepositService(DepositRepo depositRepo){
        this.depositRepo = depositRepo;
    }

    public ResponseEntity<Iterable<Deposit>> getAllDeposits(Long accountId) {
        return null;
    }

    public ResponseEntity<Deposit> getDepositById(Long depositId) {
        return null;
    }

    public ResponseEntity<Deposit> createDeposit(Long accountId, Deposit deposit) {
        return null;
    }

    public ResponseEntity<Deposit> updateDeposit(Long depositId, Deposit deposit) {
        return null;
    }

    public ResponseEntity deleteDeposit(Long depositId) {
        return null;
    }

}
