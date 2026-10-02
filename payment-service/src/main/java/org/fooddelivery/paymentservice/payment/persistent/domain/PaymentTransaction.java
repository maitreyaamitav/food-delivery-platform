package org.fooddelivery.paymentservice.payment.persistent.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment_transaction")
@Data
public class PaymentTransaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId;
    @Column(columnDefinition = "jsonb")
    private String gatewayRequest;
    @Column(columnDefinition = "jsonb")
    private String gatewayResponse;
    private String status;
    private Instant createdAt;
}
