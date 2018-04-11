package io.zipcoder.services;

import io.zipcoder.repositories.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private BillRepo billRepo;

    @Autowired
    public BillService(BillRepo billRepo){
        this.billRepo = billRepo;
    }
}
