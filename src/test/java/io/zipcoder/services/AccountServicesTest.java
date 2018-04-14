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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;


public class AccountServicesTest {

    private MockMvc mockMvc;

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Customer testCustomer = new Customer();
        testCustomer.setId(1L);
        testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setCustomer(testCustomer);
    }

    @Test
    public void getAllAccountsTest() {
        Iterable<Account> accountsList = new ArrayList<>();
        given(accountRepo.findAll()).willReturn(accountsList);

        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accountsList, OK);
        ResponseEntity<Iterable<Account>> actual = accountService.getAllAccounts();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountsByIdTest() {
        accountRepo.save(testAccount);
        when(accountRepo.findOne(1L)).thenReturn(testAccount);
        ResponseEntity<Account> expected = new ResponseEntity<>(testAccount, OK);
        ResponseEntity<Account> actual = accountService.getAccountById(testAccount.getId());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAccountsByCustomerIdTest() {
        Iterable<Account> accountsList = new ArrayList<>();
        accountRepo.save(testAccount);
        when(accountRepo.findAllAccountsByCustomerId(testAccount.getCustomer().getId())).thenReturn(accountsList);

        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accountsList, OK);
        ResponseEntity<Iterable<Account>> actual = accountService.getAllAccountsByCustomer(testAccount.getCustomer().getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createAccountTest() {
        Customer testCust = new Customer();
        testCust.setId(1L);
        when(customerRepo.findOne(anyLong())).thenReturn(testCust);
        when(accountRepo.save(any(Account.class))).thenReturn(testAccount);

        ResponseEntity<Account> expected = new ResponseEntity<>(testAccount, HttpStatus.CREATED);
        ResponseEntity<Account> actual = accountService.createAccount(testAccount, testAccount.getCustomer().getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateAccountTest() {

    }

    @Test
    public void deleteAccountTest() {
        accountRepo.save(testAccount);
        accountRepo.delete(1L);
        when(accountRepo.findOne(1L)).thenReturn(testAccount).thenReturn(null);

        verify(accountRepo, times(1)).delete(1L);
    }
}
