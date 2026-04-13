package com.doug.paynowspringbootintegration.repository;

import com.doug.paynowspringbootintegration.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByPollUrl(String pollUrl);
}
