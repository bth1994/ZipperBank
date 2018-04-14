package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.exceptions.ResourceNotFoundException;
import io.zipcoder.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AccountService {

    private AccountRepo accountRepo;
    private CustomerRepo customerRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo, CustomerRepo customerRepo){
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public Account getAccountById(Long accountId) {
        Account account = accountRepo.findOne(accountId);
        verifyAccount(accountId);
        return account;
    }

    public List<Account> getAllAccountsByCustomer(Long customerId) {
        List<Account> allAccounts = accountRepo.findAll();
        List<Account> accountsWithCustomerId = new ArrayList<>();
        for(Account account : allAccounts) {
            if(account.getCustomer().getId().equals(customerId)) {
                accountsWithCustomerId.add(account);
            }
        }
        return accountsWithCustomerId;
    }

    public ResponseEntity<Account> createAccount(Account account, Long customerId) {
        Customer customer = customerRepo.findOne(customerId);
        account = accountRepo.save(account);
        account.setCustomer(customer);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    public Account updateAccount(Long accountId, Account account) {
        verifyAccount(accountId);
        return accountRepo.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepo.delete(accountId);
    }

    private void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepo.findOne(accountId);
        if(account == null) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

}
