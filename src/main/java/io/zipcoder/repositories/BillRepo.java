package io.zipcoder.repositories;

import io.zipcoder.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Long> {
}
