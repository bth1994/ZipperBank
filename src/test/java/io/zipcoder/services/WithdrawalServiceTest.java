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

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WithdrawalServiceTest {

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private WithdrawalRepo withdrawalRepo;

    @InjectMocks
    private WithdrawalService withdrawalService;

    private Withdrawal testWithdrawal;
    private Account testAccount;

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

    }
    @Test
    public void getWithdrawalsByIdTest(){

    }
    @Test
    public void createWithdrawalTest(){

    }
    @Test
    public void updateWithdrawalTest(){

    }
    @Test
    public void deleteWithdrawalTest(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = withdrawalService.deleteWithdrawal(testWithdrawal.getId());
        verify(withdrawalRepo).delete(isA(Long.class));
        Assert.assertEquals(expected, actual);
    }
}
