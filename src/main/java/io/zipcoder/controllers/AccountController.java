package io.zipcoder.controllers;

import io.zipcoder.entities.Customer;
import io.zipcoder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsByCustomer(@PathVariable Long customerId){
        return accountService.getAllAccountsByCustomer(customerId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Customer customer, @PathVariable Long customerId){
        return accountService.createAccount(customer, customerId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long accountId){
        return accountService.updateAccount(accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        return accountService.deleteAccount(accountId);
    }
}
