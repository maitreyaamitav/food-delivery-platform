package org.fooddelivery.models.event;

import java.time.Instant;

import lombok.Data;

@Data
public class DeliveryEvent {

	private String eventId;
	private Long assignmentId;
	private Long orderId;
	private Long partnerId;
	private String status; // ASSIGNED, PICKED_UP, OUT_FOR_DELIVERY, DELIVERED
	private Instant occurredAt;

}
