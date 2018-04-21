package io.zipcoder.services;

import io.zipcoder.entities.Customer;
import io.zipcoder.entities.Deposit;
import io.zipcoder.repositories.DepositRepo;
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
public class DepositServicesTest {

    @Mock
    private DepositRepo depositRepo;

    @InjectMocks
    private DepositService depositService;

    private Deposit depositTester;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Customer tester = new Customer();
        tester.setId(1L);
        depositTester = new Deposit();
        depositTester.setId(1L);
    }

    @Test
    public void getAllDepositsTest() {
        Iterable<Deposit> depositsList = singletonList(depositTester);
        when(depositRepo.getAllDepositsFromAccId(isA(Long.class))).thenReturn(depositsList);

        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(depositsList, HttpStatus.OK);
        ResponseEntity<Iterable<Deposit>> actual = depositService.getAllDepositsFromAccountId(depositTester.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDepositsByDepositIdTest() {
        when(depositRepo.findOne(isA(Long.class))).thenReturn(depositTester);
        ResponseEntity<Deposit> expected = new ResponseEntity<>(depositTester, HttpStatus.OK);
        ResponseEntity<Deposit> actual = depositService.getDepositById(depositTester.getId());
        Assert.assertEquals(expected, actual);
        verify(depositRepo).findOne(isA(Long.class));
    }

    @Test
    public void createDepositTest() {
        when(depositRepo.findOne(1L)).thenReturn(depositTester);
        when(depositRepo.save(isA(Deposit.class))).thenReturn(depositTester);
        ResponseEntity<Deposit> expected = new ResponseEntity<>(depositTester, HttpStatus.CREATED);
        ResponseEntity<Deposit> actual = depositService.createDeposit(depositTester.getId(), depositTester);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateDepositTest() {
        when(depositRepo.save(isA(Deposit.class))).thenReturn(depositTester);
        ResponseEntity<Deposit> expected = new ResponseEntity<>(depositTester, HttpStatus.OK);
        ResponseEntity<Deposit> actual = depositService.updateDeposit(depositTester.getId(), depositTester);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteDepositTest() {
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = depositService.deleteDeposit(depositTester.getId());
        verify(depositRepo).delete(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }
}
