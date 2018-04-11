package io.zipcoder.services;

import io.zipcoder.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    private WithdrawalRepo withdrawalRepo;

    @Autowired
    public WithdrawalService(WithdrawalRepo withdrawalRepo){
        this.withdrawalRepo = withdrawalRepo;
    }


}
