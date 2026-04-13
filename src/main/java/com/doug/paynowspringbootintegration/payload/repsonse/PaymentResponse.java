package com.doug.paynowspringbootintegration.payload.repsonse;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {


     String redirectUrl;

     String pollUrl;

     String message;
}
