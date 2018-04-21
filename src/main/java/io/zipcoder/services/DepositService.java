package io.zipcoder.services;

import io.zipcoder.entities.Deposit;
import io.zipcoder.repositories.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    @Autowired
    private DepositRepo depositRepo;

    public ResponseEntity<Iterable<Deposit>> getAllDepositsFromAccount(Long accountId) {
        return new ResponseEntity<>(depositRepo.findByAccountId(accountId), HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDepositById(Long depositId) {
        return new ResponseEntity<>(depositRepo.findOne(depositId), HttpStatus.OK);
    }

    public ResponseEntity<Deposit> createDeposit(Long accountId, Deposit deposit) {
        return new ResponseEntity<>(depositRepo.save(deposit), HttpStatus.CREATED);
    }

    public ResponseEntity<Deposit> updateDeposit(Long depositId, Deposit deposit) {
        return new ResponseEntity<>(depositRepo.save(deposit), HttpStatus.OK);
    }

    public ResponseEntity deleteDeposit(Long depositId) {
        depositRepo.delete(depositId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
