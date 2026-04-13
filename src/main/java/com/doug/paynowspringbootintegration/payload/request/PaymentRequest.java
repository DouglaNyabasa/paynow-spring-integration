package com.doug.paynowspringbootintegration.payload.request;



import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {


     String invoiceNumber;

     String email;

     String cartDescription;

     List<PaymentItemRequest> items;

}
