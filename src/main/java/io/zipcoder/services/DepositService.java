package io.zipcoder.services;

import io.zipcoder.repositories.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    private DepositRepo depositRepo;

    @Autowired
    public DepositService(DepositRepo depositRepo){
        this.depositRepo = depositRepo;
    }

}
