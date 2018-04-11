package io.zipcoder.services;

import io.zipcoder.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithrawalService {

    @Autowired
    private WithdrawalRepo withdrawalRepo;

}
