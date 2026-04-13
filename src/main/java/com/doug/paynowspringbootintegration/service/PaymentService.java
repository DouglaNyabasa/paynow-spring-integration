package com.doug.paynowspringbootintegration.service;

import com.doug.paynowspringbootintegration.model.PaymentEntity;
import com.doug.paynowspringbootintegration.payload.repsonse.PaymentResponse;
import com.doug.paynowspringbootintegration.payload.request.PaymentRequest;
import com.doug.paynowspringbootintegration.payload.request.PaymentStatus;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest paymentRequest);
     PaymentStatus checkPaymentStatus(String pollUrl);
}
