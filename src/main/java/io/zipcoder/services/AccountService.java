package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
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

    public HttpHeaders createAccount(Account account, Long customerId) {
        account = accountRepo.save(account);
        account.setCustomerId(customerId);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAccountURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/customers/{customerId}/accounts")
                .buildAndExpand(customerId)
                .toUri();
        responseHeaders.setLocation(newAccountURI);

        return responseHeaders;
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
