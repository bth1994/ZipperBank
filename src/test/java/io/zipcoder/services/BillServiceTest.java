package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Bill;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.BillRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;

public class BillServiceTest {

    private MockMvc mockMvc;
    private Bill testBill;
    private Account testAccount;
    private Customer testCustomer;

    @Mock
    private BillRepo billRepo;

    @InjectMocks
    private BillService billService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testBill = new Bill();

    }

    @Test
    public void getBillsByAccountTest() {
        testBill = new Bill();
        testBill.setId(7L);
        billRepo.save(testBill);
        Iterable<Bill> bills = singletonList(testBill);

        when(billRepo.findOne(7L)).thenReturn(testBill);

        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        ResponseEntity<Iterable<Bill>> actual = billService.getBillsByAccount(testBill.getId());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBillByBillIdTest() {


    }

    @Test
    public void getBillsByCustomerId() {


    }

    @Test
    public void createBillTest() {


    }

    @Test
    public void updateBillTest() {


    }

    @Test
    public void deleteBillTest() {


    }


}
