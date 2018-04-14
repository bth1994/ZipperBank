package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.exceptions.ResourceNotFoundException;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public ResponseEntity<Customer> getCustomerByAccountId(Long accountId) {

        return null;
    }

    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerByCustomerId(Long id) {
        verifyCustomer(id);
        return new ResponseEntity<>(customerRepo.findOne(id), HttpStatus.OK);
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
    }

    public ResponseEntity<Customer> updateCustomer(Long customerId, Customer customer) {
        verifyCustomer(customerId);
        return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
    }

    private void verifyCustomer(Long customerId) throws ResourceNotFoundException {
        Customer customer = customerRepo.findOne(customerId);
        if(customer == null) {
            throw new ResourceNotFoundException("Account with id " + customerId + " not found");
        }
    }

}
