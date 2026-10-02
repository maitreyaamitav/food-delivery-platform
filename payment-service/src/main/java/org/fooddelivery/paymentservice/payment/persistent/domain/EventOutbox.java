package org.fooddelivery.paymentservice.payment.persistent.domain;

import java.time.Instant;

import org.fooddelivery.models.event.PaymentEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "event_outbox")
@Data
public class EventOutbox {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aggregateType;
    private Long aggregateId;
    private String eventType;
    @Column(columnDefinition = "jsonb")
    private PaymentEvent payload;
    private String status;
    private Instant createdAt;
    private Instant publishedAt;
}
