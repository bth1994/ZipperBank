package io.zipcoder.controllers;

import io.zipcoder.entities.Bill;
import io.zipcoder.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getBillsByAccount(@PathVariable Long accountId) {
        return this.billService.getBillsByAccount(accountId);
    }

    @RequestMapping(value = "/bills/{billId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Bill> getBillByBillId(@PathVariable Long billId) {
        return this.billService.getBillByBillId(billId);
    }

    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(@PathVariable Long customerId) {
        return this.billService.getBillsByCustomerId(customerId);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<Bill> createBill(@PathVariable Long accountId, @RequestBody Bill bill) {
        return this.billService.createBill(accountId, bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<Bill> updateBill(@PathVariable Long billId, @RequestBody Bill bill) {
        return this.billService.updateBill(billId, bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBill(@PathVariable Long billId) {
        return this.billService.deleteBill(billId);
    }

}