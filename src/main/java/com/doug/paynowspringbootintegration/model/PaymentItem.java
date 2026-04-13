package com.doug.paynowspringbootintegration.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "paymentItems")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String name;

     BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "payment_id")
     Payment payment;

    @Override
    public String toString() {
        return "PaymentItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
