package io.zipcoder.services;

import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public ResponseEntity<?> getAllAccounts() {

        return null;
    }

    public ResponseEntity<?> getAccountById(Long accountId) {
        return null;
    }

    public ResponseEntity<?> getAllAccountsByCustomer(Long customerId) {
        return null;
    }

    public ResponseEntity<?> createAccount(Customer customer, Long customerId) {
        return null;
    }

    public ResponseEntity<?> updateAccount(Long accountId) {
        return null;
    }

    public ResponseEntity<?> deleteAccount(Long accountId) {
        return null;
    }

}
