package io.zipcoder.services;

import io.zipcoder.repositories.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    @Autowired
    private DepositRepo depositRepo;

}
