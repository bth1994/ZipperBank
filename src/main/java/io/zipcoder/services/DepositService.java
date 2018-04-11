package io.zipcoder.services;

import io.zipcoder.entities.Deposit;
import io.zipcoder.repositories.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class DepositService {

    private DepositRepo depositRepo;

    @Autowired
    public DepositService(DepositRepo depositRepo){
        this.depositRepo = depositRepo;
    }

    public ResponseEntity<?> getAllDeposits(Long accountId) {
        return null;
    }

    public ResponseEntity<?> getDepositById(Long depositId) {
        return null;
    }

    public ResponseEntity<?> createDeposit(Long accountId, Deposit deposit) {
        return null;
    }

    public ResponseEntity<?> updateDeposit(Long depositId, Deposit deposit) {
        return null;
    }

    public ResponseEntity<?> deleteDeposit(Long depositId) {
        return null;
    }

}
