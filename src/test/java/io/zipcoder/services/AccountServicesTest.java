package io.zipcoder.services;

import io.zipcoder.controllers.AccountController;
import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.CustomerRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


public class AccountServicesTest {

    private MockMvc mockMvc;

    @Mock
    private AccountRepo accountRepo;

    @MockBean
    private CustomerRepo customerRepo;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Customer testCustomer = new Customer();
        testCustomer.setId(1L);
        testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setCustomer(testCustomer);
    }

    @Test
    public void getAllAccountsTest(){

    }

    @Test
    public void getAccountsByIdTest(){
        accountRepo.save(testAccount);
        when(accountRepo.findOne(1L)).thenReturn(testAccount);
       ResponseEntity<Account> expected = new ResponseEntity<>(testAccount, HttpStatus.OK);
       ResponseEntity<Account> actual = accountService.getAccountById(testAccount.getId());
       Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAllAccountsByCustomerIdTest(){

    }
    @Test
    public void createAccountTest(){

    }
    @Test
    public void updateAccountTest(){

    }
    @Test
    public void deleteAccountTest(){

    }
}
