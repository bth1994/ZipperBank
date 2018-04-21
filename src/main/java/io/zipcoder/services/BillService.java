package io.zipcoder.services;

import io.zipcoder.entities.Account;
import io.zipcoder.entities.Bill;
import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.repositories.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private BillRepo billRepo;
    private AccountRepo accountRepo;

    @Autowired
    public BillService(BillRepo billRepo, AccountRepo accountRepo){
        this.billRepo = billRepo;
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByAccount(Long accountId) {
        return new ResponseEntity<>(billRepo.findAllBillsByAccountId(accountId), HttpStatus.OK);
    }

    public ResponseEntity<Bill> getBillByBillId(Long billId) {
        return new ResponseEntity<>(billRepo.findOne(billId), HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId) {
        return new ResponseEntity<>(billRepo.findAllBillsByAccount_Customer_Id(customerId), HttpStatus.OK);
    }

    public ResponseEntity<Bill> createBill(Long accountId, Bill bill) {
        Account account = accountRepo.findOne(accountId);
        bill.setAccount(account);
        Bill savedBill = billRepo.save(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    public ResponseEntity<Bill> updateBill(Long billId, Bill bill) {
        bill.setId(billId);
        Bill savedBill = billRepo.save(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.OK);
    }

    public ResponseEntity deleteBill(Long billId) {
        billRepo.delete(billId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
