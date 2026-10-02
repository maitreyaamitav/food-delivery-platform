package org.fooddelivery.models.event;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

@Data
public class PaymentEvent {

	private String eventId;
	private Long paymentId;
	private Long orderId;
	private BigDecimal amount;
	private String status; // INITIATED, SUCCEEDED, FAILED
	private Instant occurredAt;

}
