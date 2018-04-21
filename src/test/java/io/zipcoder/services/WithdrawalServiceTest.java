package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Customer;
import io.zipcoder.entities.Withdrawal;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.WithdrawalRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WithdrawalServiceTest {

    @Mock
    private WithdrawalRepo withdrawalRepo;

    @InjectMocks
    private WithdrawalService withdrawalService;

    private Withdrawal testWithdrawal;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Customer testCustomer = new Customer();
        testCustomer.setId(1L);
        testWithdrawal = new Withdrawal();
        testWithdrawal.setId(1L);
    }

    @Test
    public void getAllWithdrawalsFromAccountIdTest(){
        Iterable<Withdrawal> withdrawalList = singletonList(testWithdrawal);
        when(withdrawalRepo.findByAccountId(isA(Long.class))).thenReturn(withdrawalList);

        ResponseEntity<Iterable<Withdrawal>> expected = new ResponseEntity<>(withdrawalList, HttpStatus.OK);
        ResponseEntity<Iterable<Withdrawal>> actual = withdrawalService.getAllWithdrawalsFromAccountId(testWithdrawal.getId());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getWithdrawalsByIdTest(){
        when(withdrawalRepo.findOne(isA(Long.class))).thenReturn(testWithdrawal);
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(testWithdrawal, HttpStatus.OK);
        ResponseEntity<Withdrawal> actual = withdrawalService.getWithdrawalsByWithdrawalId(testWithdrawal.getId());
        Assert.assertEquals(expected, actual);
        verify(withdrawalRepo).findOne(isA(Long.class));
    }
    @Test
    public void createWithdrawalTest(){
        when(withdrawalRepo.findOne(1L)).thenReturn(testWithdrawal);
        when(withdrawalRepo.save(isA(Withdrawal.class))).thenReturn(testWithdrawal);
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(testWithdrawal, HttpStatus.CREATED);
        ResponseEntity<Withdrawal> actual = withdrawalService.createWithdrawal(testWithdrawal.getId(), testWithdrawal);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void updateWithdrawalTest(){
        when(withdrawalRepo.save(isA(Withdrawal.class))).thenReturn(testWithdrawal);
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(testWithdrawal, HttpStatus.OK);
        ResponseEntity<Withdrawal> actual = withdrawalService.updateWithdrawal(testWithdrawal.getId(), testWithdrawal);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void deleteWithdrawalTest(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = withdrawalService.deleteWithdrawal(testWithdrawal.getId());
        verify(withdrawalRepo).delete(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }
}
