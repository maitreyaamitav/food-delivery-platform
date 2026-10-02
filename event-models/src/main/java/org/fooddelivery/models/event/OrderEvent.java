package org.fooddelivery.models.event;

import java.time.Instant;

import lombok.Data;

@Data
public class OrderEvent {

	private String eventId;
	private Long orderId;
	private String newStatus; // CREATED, READY_FOR_PICKUP, DELIVERED
	private Instant occurredAt;
}
