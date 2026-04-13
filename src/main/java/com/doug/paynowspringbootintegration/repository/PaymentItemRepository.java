package com.doug.paynowspringbootintegration.repository;

import com.doug.paynowspringbootintegration.model.PaymentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentItemRepository extends JpaRepository<PaymentItem,Long> {
}
