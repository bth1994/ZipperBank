package io.zipcoder.services;

import io.zipcoder.entities.Bill;
import io.zipcoder.repositories.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private BillRepo billRepo;

    @Autowired
    public BillService(BillRepo billRepo){
        this.billRepo = billRepo;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByAccount(Long accountId) {
        return null;
    }

    public ResponseEntity<Bill> getBillByBillId(Long billId) {
        return null;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId) {
        return null;
    }

    public ResponseEntity<Bill> createBill(Long accountId, Bill bill) {
        return null;
    }

    public ResponseEntity<Bill> updateBill(Long billId, Bill bill) {
        return null;
    }

    public ResponseEntity deleteBill(Long billId) {
        return null;
    }

}
