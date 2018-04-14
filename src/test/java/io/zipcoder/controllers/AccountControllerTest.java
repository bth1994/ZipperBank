package io.zipcoder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.services.AccountService;
import io.zipcoder.utilities.AccountType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private ObjectMapper om;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        om = new ObjectMapper();
    }

    @Test
    public void getAllAccountsTest() throws Exception {

        List<Account> accountList = new ArrayList<>();
        Customer customer = new Customer();
        Customer customer2 = new Customer();
        Account account1 = new Account("Joey", AccountType.CHECKING, 500.00, customer);
        Account account2 = new Account("Vince", AccountType.CHECKING, 400.00, customer2);
        accountList.add(account1);
        accountList.add(account2);

        when(accountService.getAllAccounts()).thenReturn(accountList);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].nickname", is("Joey")))
//                .andExpect(jsonPath("$[0].type", is("CHECKING")))
//                .andExpect(jsonPath("$[0].balance", is(500.00)));

        verify(accountService, times(1)).getAllAccounts();
    }

    @Test
    public void getAccountByIdTest() throws Exception {
        Customer customer = new Customer();
        Account account1 = new Account("Joey", AccountType.CHECKING, 500.00, customer);

        when(accountService.getAccountById(2L)).thenReturn(account1);

        mockMvc.perform(get("/accounts/2"))
                .andExpect(status().isOk());

        verify(accountService, times(1)).getAccountById(2L);
    }

    @Test
    public void getAllAccountsByCustomerTest() throws Exception {
        List<Account> accountList = new ArrayList<>();
        Customer customer = new Customer();
        Account account1 = new Account("Joeys Checking", AccountType.CHECKING, 500.00, customer);
        Account account2 = new Account("Joeys Savings", AccountType.SAVINGS, 400.00, customer);
        accountList.add(account1);
        accountList.add(account2);

        when(accountService.getAllAccountsByCustomer(14L)).thenReturn(accountList);

        mockMvc.perform(get("/customers/14/accounts")).andExpect(status().isOk());

        verify(accountService, times(1)).getAllAccountsByCustomer(14L);
    }

    @Test
    public void createAccountTest() throws Exception {
        Account newAccount = new Account();
        Customer someCustomer = new Customer();
        someCustomer.setId(1L);
        newAccount.setCustomer(someCustomer);

        String body = om.writeValueAsString(newAccount);

        when(accountService.createAccount(newAccount, someCustomer.getId())).thenReturn(mock(ResponseEntity.class));


        mockMvc.perform(post("/customers/1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAccountTest() throws Exception {
        Account testAccount = new Account();
        String body = om.writeValueAsString(testAccount);

        when(accountService.updateAccount(isA(Long.class), isA(Account.class))).thenReturn(testAccount);

        mockMvc.perform(put("/accounts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }

    @Test
    public void deleteAccountTest() throws Exception {

        mockMvc.perform(delete("/accounts/1")).andExpect(status().isOk());
    }

}
