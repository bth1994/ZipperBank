package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Account> getAllAccountsByCustomer(Long customerId) {
        List<Account> allAccounts = accountRepo.findAll();
        List<Account> accountsWithCustomerId = new ArrayList<>();
        for(Account account : allAccounts) {
            if(account.getCustomerId().equals(customerId)) {
                accountsWithCustomerId.add(account);
            }
        }
        return accountsWithCustomerId;
    }

    public void createAccount(Account account, Long customerId) {
        accountRepo.save(account).setCustomerId(customerId);
    }

    public Account updateAccount(Long accountId, Account account) {
        verifyAccount(accountId);
        return accountRepo.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepo.delete(accountId);
    }

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepo.findOne(accountId);
        if(account == null) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

}
