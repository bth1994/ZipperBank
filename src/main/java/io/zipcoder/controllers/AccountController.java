package io.zipcoder.controllers;

import io.zipcoder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts(){
        return accountService.getAllAccounts();
    }

}
