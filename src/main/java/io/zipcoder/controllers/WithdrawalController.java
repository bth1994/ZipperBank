package io.zipcoder.controllers;

import io.zipcoder.entities.Withdrawal;
import io.zipcoder.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;

public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWithdrawalsFromAccountId(@PathVariable Long accountId){
        return withdrawalService.getAllWithdrawalsFromAccountId(accountId);
    }
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalsByWithdrawalId(@PathVariable Long withdrawalId){
        return withdrawalService.getWithdrawalsByWithdrawalId(withdrawalId);
    }
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long accountId, @RequestBody Withdrawal withdrawal){
        return withdrawalService.createWithdrawal(accountId, withdrawal);
    }
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@PathVariable Long withdrawalId, @RequestBody Withdrawal withdrawal){
        return withdrawalService.updateWithdrawal(withdrawalId, withdrawal);
    }
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        return withdrawalService.deleteWithdrawal(withdrawalId);
    }
}
