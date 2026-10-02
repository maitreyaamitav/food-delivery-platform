package org.fooddelivery.deliveryservice.delivery.persistent.domain;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "delivery_assignment")
@Data
public class DeliveryAssignment {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long partnerId;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;
}
