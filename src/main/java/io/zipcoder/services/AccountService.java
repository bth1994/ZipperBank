package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public Account getAccountById(Long accountId) {
        Account account = accountRepo.findOne(accountId);
        verifyAccount(accountId);
        return account;
    }

    public ResponseEntity<Iterable<Account>> getAllAccountsByCustomer(Customer customer) {
        Iterable<Account> accountsContainingId = accountRepo.findAll();
       while(accountsContainingId.iterator().hasNext()) {

       }
        return null;
    }

    public void createAccount(Account account, Long customerId) {
        //Find customer by id and add account
    }

    public Account updateAccount(Long accountId, Account account) {
        verifyAccount(accountId);
        return accountRepo.save(account);
    }

    public ResponseEntity deleteAccount(Long accountId) {
        return null;
    }

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepo.findOne(accountId);
        if(account == null) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

}
