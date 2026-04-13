package com.doug.paynowspringbootintegration.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    String reference;
    String redirectUrl;
    String pollUrl;
    String status;
    String email;
    String cartDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
    private List<PaymentItem> items = new ArrayList<PaymentItem>();

}
