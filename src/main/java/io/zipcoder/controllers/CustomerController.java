package io.zipcoder.controllers;

import io.zipcoder.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerController {

    @Autowired
    private CustomerService customerService;

}
