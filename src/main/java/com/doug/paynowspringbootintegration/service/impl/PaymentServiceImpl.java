package com.doug.paynowspringbootintegration.service.impl;

import com.doug.paynowspringbootintegration.model.PaymentEntity;
import com.doug.paynowspringbootintegration.model.PaymentItem;
import com.doug.paynowspringbootintegration.payload.repsonse.PaymentResponse;
import com.doug.paynowspringbootintegration.payload.request.PaymentRequest;
import com.doug.paynowspringbootintegration.payload.request.PaymentStatus;
import com.doug.paynowspringbootintegration.repository.PaymentRepository;
import com.doug.paynowspringbootintegration.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import zw.co.paynow.constants.MobileMoneyMethod;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.MobileInitResponse;
import zw.co.paynow.responses.WebInitResponse;

import java.math.BigDecimal;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final Paynow paynow;
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(Paynow paynow, PaymentRepository paymentRepository) {
        this.paynow = paynow;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {

        // calculating total amount
        BigDecimal totalAmount = paymentRequest.getItems().stream()
                .map(item -> BigDecimal.valueOf(item.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Create and save the payment entity
        PaymentEntity paymentEntity =  PaymentEntity.builder()
                .email(paymentRequest.getEmail())
                .invoiceNumber(paymentRequest.getInvoiceNumber())
                .cartDescription(paymentRequest.getCartDescription())
                .amount(totalAmount)
                .build();

        // Create Paynow payment
        Payment payment = paynow.createPayment(paymentRequest.getInvoiceNumber(),paymentRequest.getEmail() != null ? paymentRequest.getEmail() : "");

        // add items
        paymentRequest.getItems().forEach(item->{
            payment.add(item.getName(), item.getPrice());


            // Save payment items
            PaymentItem paymentItem = new PaymentItem();
            paymentItem.setName(item.getName());
            paymentItem.setPrice(BigDecimal.valueOf(item.getPrice()));
            paymentItem.setPaymentEntity(paymentEntity);
            paymentEntity.getItems().add(paymentItem);
        });

        WebInitResponse webInitResponse = paynow.send(payment);

        if (webInitResponse.success()){
              // updating the payment entity with paynow details

            paymentEntity.setStatus("INITIATED");
            paymentEntity.setPollUrl(webInitResponse.getPollUrl());
            paymentEntity.setRedirectUrl(webInitResponse.redirectURL());

            // saving to the database

            paymentRepository.save(paymentEntity);

            return new PaymentResponse(
                    webInitResponse.redirectURL(),
                    webInitResponse.pollUrl(),
                    "Payment initiated successfully"

            );

        }
        else {
            paymentEntity.setStatus("FAILED");
            paymentRepository.save(paymentEntity);
            throw new RuntimeException("Failed to initiate payment");
        }
    }

    @Override
    public PaymentStatus checkPaymentStatus(String pollUrl) {
        return null;
    }
}
