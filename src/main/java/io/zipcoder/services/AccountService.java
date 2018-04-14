package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.exceptions.ResourceNotFoundException;
import io.zipcoder.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepo accountRepo;
    private CustomerRepo customerRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo, CustomerRepo customerRepo){
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Account> getAccountById(Long accountId) {
        Account account = accountRepo.findOne(accountId);
        verifyAccount(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Account>> getAllAccountsByCustomer(Long customerId) {
        return new ResponseEntity<>(accountRepo.findAllAccountsByCustomerId(customerId), HttpStatus.OK);
    }

    public ResponseEntity<Account> createAccount(Account account, Long customerId) {
        Customer customer = customerRepo.findOne(customerId);
        account.setCustomer(customer);
        account = accountRepo.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    public ResponseEntity<Account> updateAccount(Long accountId, Account account) {
        verifyAccount(accountId);
        return new ResponseEntity<>(accountRepo.save(account), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAccount(Long accountId) {
        accountRepo.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepo.findOne(accountId);
        if(account == null) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }
}
