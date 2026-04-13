package com.doug.paynowspringbootintegration.payload.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentStatus {


     boolean paid;

     String status;

     double amount;

    public PaymentStatus(boolean paid, String status, double amount) {
        this.paid = paid;
        this.status = status;
        this.amount = amount;
    }
}
