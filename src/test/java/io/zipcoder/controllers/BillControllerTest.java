package io.zipcoder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.entities.Account;
import io.zipcoder.entities.Bill;
import io.zipcoder.entities.Customer;
import io.zipcoder.services.BillService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTest {

    private MockMvc mockMvc;
    private Bill testBill;
    private Account testAccount;
    private Customer testCustomer;
    private ObjectMapper mapper;

    @MockBean
    private BillService billService;

    @InjectMocks
    private BillController billController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(billController).build();
        testBill = new Bill();
        testAccount = new Account();
        testCustomer = new Customer();
        mapper = new ObjectMapper();
    }

    @Test
    public void getBillsByAccountTest() throws Exception {
        Iterable<Bill> bills = singletonList(testBill);
        ResponseEntity<Iterable<Bill>> responseEntity = new ResponseEntity<>(bills, HttpStatus.OK);

        when(billService.getBillsByAccount(testAccount.getId())).thenReturn(responseEntity);

        mockMvc.perform(get("/accounts/14/bills"))
                .andExpect(status().isOk());

        verify(billService, times(1)).getBillsByAccount(isA(Long.class));
    }

    @Test
    public void getBillByBillIdTest() throws Exception {
        ResponseEntity<Bill> responseEntity = new ResponseEntity<>(testBill, HttpStatus.OK);

        when(billService.getBillByBillId(testBill.getId())).thenReturn(responseEntity);

        mockMvc.perform(get("/bills/7/bills"))
                .andExpect(status().isOk());

        verify(billService, times(1)).getBillByBillId(isA(Long.class));
    }

    @Test
    public void getBillsByCustomerIdTest() throws Exception {
        Iterable<Bill> bills = singletonList(testBill);
        ResponseEntity<Iterable<Bill>> responseEntity = new ResponseEntity<>(bills, HttpStatus.OK);

        when(billService.getBillsByCustomerId(testCustomer.getId())).thenReturn(responseEntity);

        mockMvc.perform(get("/customers/3/bills"))
                .andExpect(status().isOk());

        verify(billService, times(1)).getBillsByCustomerId(isA(Long.class));
    }

    @Test
    public void createBillTest() throws Exception {
        ResponseEntity<Bill> responseEntity = new ResponseEntity<>(testBill, HttpStatus.CREATED);
        String body = mapper.writeValueAsString(testBill);

        when(billService.createBill(testAccount.getId(), testBill)).thenReturn(responseEntity);

        mockMvc.perform(post("/accounts/23/bills")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(billService, times(1)).createBill(isA(Long.class), isA(Bill.class));
    }

    @Test
    public void updateBillTest() throws Exception {
        ResponseEntity<Bill> responseEntity = new ResponseEntity<>(testBill, HttpStatus.OK);
        String body = mapper.writeValueAsString(testBill);

        when(billService.updateBill(testBill.getId(), testBill)).thenReturn(responseEntity);

        mockMvc.perform(put("/bills/11")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(billService, times(1)).updateBill(isA(Long.class), isA(Bill.class));
    }

    @Test
    public void deleteBillTest() throws Exception {
        mockMvc.perform(delete("/bills/193")).andExpect(status().isOk());
    }

}
