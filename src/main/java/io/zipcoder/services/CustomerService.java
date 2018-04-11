package io.zipcoder.services;

import io.zipcoder.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }
}
