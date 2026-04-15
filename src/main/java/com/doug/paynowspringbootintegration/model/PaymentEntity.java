package com.doug.paynowspringbootintegration.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    String invoiceNumber;
    String reference;
    String redirectUrl;
    String pollUrl;
    String status;
    String email;
    String cartDescription;


    @Builder.Default
    @OneToMany(mappedBy = "paymentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PaymentItem> items = new ArrayList<>();


}
