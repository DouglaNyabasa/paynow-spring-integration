package com.doug.paynowspringbootintegration.controller;


import com.doug.paynowspringbootintegration.payload.repsonse.PaymentResponse;
import com.doug.paynowspringbootintegration.payload.request.PaymentRequest;
import com.doug.paynowspringbootintegration.payload.request.PaymentStatus;
import com.doug.paynowspringbootintegration.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/createPayment")
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest){
        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping("/getPaymentStatus")
    public ResponseEntity<PaymentStatus> checkPaymentStatus(@RequestParam("pollUrl") String pollUrl){
        try {
            PaymentStatus status = paymentService.checkPaymentStatus(pollUrl);
            return ResponseEntity.ok(status);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PaymentStatus(false, "Error: " + e.getMessage(), 0));
        }
    }
}
