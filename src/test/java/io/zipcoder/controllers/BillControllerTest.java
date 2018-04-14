package io.zipcoder.controllers;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Bill;
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

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTest {

    private MockMvc mockMvc;
    private Bill testBill;
    private Account testAccount;

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
        testAccount.setId(14L);
        testBill.setAccountId(testAccount);
    }

    @Test
    public void getBillsByAccountTest() throws Exception {

        Iterable<Bill> bills = singletonList(testBill);
        ResponseEntity<Iterable<Bill>> responseEntity = new ResponseEntity<>(bills, HttpStatus.OK);

        when(billService.getBillsByAccount(testAccount.getId())).thenReturn(responseEntity);

        mockMvc.perform(get("/accounts/14/bills"))
                .andExpect(status().isOk());

    }


}
