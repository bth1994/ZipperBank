package io.zipcoder.controllers;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccountsByCustomer(@PathVariable Customer customer){
        return accountService.getAllAccountsByCustomer(customer);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public void createAccount(@RequestBody Account account, @PathVariable Long customerId){
        accountService.createAccount(account, customerId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account){
        return accountService.updateAccount(accountId, account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable Long accountId){
        return accountService.deleteAccount(accountId);
    }
}
