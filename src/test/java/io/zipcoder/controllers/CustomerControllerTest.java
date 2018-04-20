package io.zipcoder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper mapper;
    private Account testAccount;
    private Customer testCustomer;

    @MockBean
    private CustomerService customerService;

    @InjectMocks CustomerController customerController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        mapper = new ObjectMapper();
        testAccount = new Account();
        testCustomer = new Customer();
    }

    @Test
    public void getCustomerByAccountIdTest() throws Exception {
        ResponseEntity<Customer> response = new ResponseEntity<>(testCustomer, HttpStatus.OK);

        when(customerService.getCustomerByAccountId(testAccount.getId())).thenReturn(response);

        mockMvc.perform(get("/accounts/14/customer")).andExpect(status().isOk());

        verify(customerService, times(1)).getCustomerByAccountId(isA(Long.class));
    }

    @Test
    public void getAllCustomersTest() throws Exception {
        Iterable<Customer> customers = singletonList(testCustomer);
        ResponseEntity<Iterable<Customer>> responseEntity = new ResponseEntity<>(customers, HttpStatus.OK);

        when(customerService.getAllCustomers()).thenReturn(responseEntity);

        mockMvc.perform(get("/customers")).andExpect(status().isOk());

        verify(customerService, times(1)).getAllCustomers();
    }


    @Test
    public void getCustomerByCustomerIdTest() throws Exception {
        ResponseEntity<Customer> response = new ResponseEntity<>(testCustomer, HttpStatus.OK);

        when(customerService.getCustomerByCustomerId(testCustomer.getId())).thenReturn(response);

        mockMvc.perform(get("/customers/11")).andExpect(status().isOk());

        verify(customerService, times(1)).getCustomerByCustomerId(isA(Long.class));
    }

    @Test
    public void createCustomerTest() throws Exception {
        ResponseEntity<Customer> response = new ResponseEntity<>(testCustomer, HttpStatus.CREATED);
        String body = mapper.writeValueAsString(testCustomer);

        when(customerService.createCustomer(testCustomer)).thenReturn(response);

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(customerService, times(1)).createCustomer(isA(Customer.class));
    }

    @Test
    public void updateCustomerTest() throws Exception {
        ResponseEntity<Customer> response = new ResponseEntity<>(testCustomer, HttpStatus.OK);
        String body = mapper.writeValueAsString(testCustomer);

        when(customerService.updateCustomer(testCustomer.getId(), testCustomer)).thenReturn(response);

        mockMvc.perform(put("/customers/561")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(customerService, times(1)).updateCustomer(isA(Long.class), isA(Customer.class));
    }

}
