package com.doug.paynowspringbootintegration.repository;

import com.doug.paynowspringbootintegration.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    Optional<PaymentEntity> findByPollUrl(String pollUrl);
}
