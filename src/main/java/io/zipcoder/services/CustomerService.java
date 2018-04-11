package io.zipcoder.services;

import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public ResponseEntity<?> getCustomerByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<?> getAllCustomers() {
        return null;
    }

    public ResponseEntity<?> getCustomerByCustomerId(Long id) {
        return null;
    }

    public ResponseEntity<?> createCustomer(Customer customer) {
        return null;
    }

    public ResponseEntity<?> updateCustomer(Long customerId) {
        return null;
    }

}
