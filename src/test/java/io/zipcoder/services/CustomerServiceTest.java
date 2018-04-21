package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.CustomerRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    private Customer testCustomer;
    private Account testAccount;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private AccountRepo accountRepo;

    @InjectMocks
    private CustomerService customerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        testCustomer = new Customer();
        testCustomer.setId(7L);

        testAccount = new Account();
        testAccount.setCustomer(testCustomer);
    }

    @Test
    public void getCustomerByAccountIdTest() {
        when(accountRepo.findOne(isA(Long.class))).thenReturn(testAccount);

        ResponseEntity<Customer> expected = new ResponseEntity<>(testCustomer, HttpStatus.OK);
        ResponseEntity<Customer> actual = customerService.getCustomerByAccountId(testCustomer.getId());

        verify(accountRepo).findOne(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllCustomersTest() {
        Iterable<Customer> customers = singletonList(testCustomer);
        when(customerRepo.findAll()).thenReturn(customers);

        ResponseEntity<Iterable<Customer>> expected = new ResponseEntity<>(customers, HttpStatus.OK);
        ResponseEntity<Iterable<Customer>> actual = customerService.getAllCustomers();

        verify(customerRepo).findAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCustomerByCustomerIdTest() {
        when(customerRepo.findOne(isA(Long.class))).thenReturn(testCustomer);

        ResponseEntity<Customer> expected = new ResponseEntity<>(testCustomer, HttpStatus.OK);
        ResponseEntity<Customer> actual = customerService.getCustomerByCustomerId(testCustomer.getId());

        verify(customerRepo).findOne(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createCustomerTest() {
        when(customerRepo.save(isA(Customer.class))).thenReturn(testCustomer);

        ResponseEntity<Customer> expected = new ResponseEntity<>(testCustomer, HttpStatus.CREATED);
        ResponseEntity<Customer> actual = customerService.createCustomer(testCustomer);

        verify(customerRepo).save(isA(Customer.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateCustomerTest() {
        when(customerRepo.exists(isA(Long.class))).thenReturn(true);
        when(customerRepo.save(isA(Customer.class))).thenReturn(testCustomer);

        ResponseEntity<Customer> expected = new ResponseEntity<>(testCustomer, HttpStatus.OK);
        ResponseEntity<Customer> actual = customerService.updateCustomer(testCustomer.getId(), testCustomer);

        verify(customerRepo).save(isA(Customer.class));
        Assert.assertEquals(expected, actual);
    }
    

}
