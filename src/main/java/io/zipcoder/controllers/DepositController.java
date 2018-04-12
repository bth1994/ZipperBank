package io.zipcoder.controllers;

import io.zipcoder.entities.Deposit;
import io.zipcoder.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepositController {

    private DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(@PathVariable Long accountId) {
        return this.depositService.getAllDeposits(accountId);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long depositId) {
        return this.depositService.getDepositById(depositId);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<Deposit> createDeposit(@PathVariable Long accountId, @RequestBody Deposit deposit) {
        return this.depositService.createDeposit(accountId, deposit);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<Deposit> updateDeposit(@PathVariable Long depositId, @RequestBody Deposit deposit) {
        return this.depositService.updateDeposit(depositId, deposit);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDeposit(@PathVariable Long depositId) {
        return this.depositService.deleteDeposit(depositId);
    }
}
