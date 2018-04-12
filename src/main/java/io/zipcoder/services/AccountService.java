package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Iterable<Account>> getAllAccounts() {

        return null;
    }

    public ResponseEntity<Account> getAccountById(Long accountId) {
        return null;
    }

    public ResponseEntity<Account> getAllAccountsByCustomer(Long customerId) {
        return null;
    }

    public ResponseEntity<Account> createAccount(Customer customer, Long customerId) {
        return null;
    }

    public ResponseEntity<Account> updateAccount(Long accountId, Account account) {
        return null;
    }

    public ResponseEntity deleteAccount(Long accountId) {
        return null;
    }

}
