package com.doug.paynowspringbootintegration.service;

import com.doug.paynowspringbootintegration.model.Payment;
import com.doug.paynowspringbootintegration.payload.request.PaymentRequest;
import com.doug.paynowspringbootintegration.payload.request.PaymentStatus;

public interface PaymentService {

     Payment createPayment(PaymentRequest paymentRequest);
     PaymentStatus checkPaymentStatus(String pollUrl);
}
