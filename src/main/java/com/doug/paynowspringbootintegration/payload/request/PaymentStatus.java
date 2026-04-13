package com.doug.paynowspringbootintegration.payload.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentStatus {


     boolean paid;

     String status;

     BigDecimal amount;
}
