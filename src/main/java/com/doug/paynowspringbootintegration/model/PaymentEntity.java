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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
    private List<PaymentItem> items = new ArrayList<PaymentItem>();

}
