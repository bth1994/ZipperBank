package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Bill;
import io.zipcoder.entities.Customer;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.BillRepo;
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

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BillServiceTest {

    private Bill testBill;
    private Account testAccount;
    private Customer testCustomer;

    @Mock
    private BillRepo billRepo;

    @Mock
    private AccountRepo accountRepo;

    @InjectMocks
    private BillService billService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        testCustomer = new Customer();
        testCustomer.setId(11L);

        testAccount = new Account();
        testAccount.setId(4L);
        testAccount.setCustomer(testCustomer);

        testBill = new Bill();
        testBill.setId(7L);
        testBill.setAccount(testAccount);
    }

    @Test
    public void getBillsByAccountTest() {
        Iterable<Bill> bills = singletonList(testBill);
        when(billRepo.findAllBillsByAccountId(isA(Long.class))).thenReturn(bills);

        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        ResponseEntity<Iterable<Bill>> actual = billService.getBillsByAccount(testAccount.getId());

        verify(billRepo).findAllBillsByAccountId(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBillByBillIdTest() {
        when(billRepo.findOne(isA(Long.class))).thenReturn(testBill);
        ResponseEntity<Bill> expected = new ResponseEntity<>(testBill, HttpStatus.OK);
        ResponseEntity<Bill> actual = billService.getBillByBillId(testBill.getId());
        verify(billRepo).findOne(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBillsByCustomerId() {
        Iterable<Bill> bills = singletonList(testBill);
        when(billRepo.findAllBillsByAccount_Customer_Id(isA(Long.class))).thenReturn(bills);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        ResponseEntity<Iterable<Bill>> actual = billService.getBillsByCustomerId(testCustomer.getId());
        verify(billRepo).findAllBillsByAccount_Customer_Id(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createBillTest() {
        when(accountRepo.findOne(isA(Long.class))).thenReturn(testAccount);
        when(billRepo.save(isA(Bill.class))).thenReturn(testBill);

        ResponseEntity<Bill> expected = new ResponseEntity<>(testBill, HttpStatus.CREATED);
        ResponseEntity<Bill> actual = billService.createBill(testAccount.getId(), testBill);

        verify(billRepo).save(isA(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateBillTest() {
        when(billRepo.save(isA(Bill.class))).thenReturn(testBill);

        ResponseEntity<Bill> expected = new ResponseEntity<>(testBill, HttpStatus.OK);
        ResponseEntity<Bill> actual = billService.updateBill(testBill.getId(), testBill);

        verify(billRepo).save(isA(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteBillTest() {
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = billService.deleteBill(testBill.getId());
        verify(billRepo).delete(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }


}
