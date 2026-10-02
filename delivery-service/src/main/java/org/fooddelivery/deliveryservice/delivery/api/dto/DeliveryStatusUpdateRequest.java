package org.fooddelivery.deliveryservice.delivery.api.dto;

import lombok.Data;

@Data
public class DeliveryStatusUpdateRequest {

	private Long assignmentId;
	private String newStatus; // ASSIGNED, PICKED_UP, OUT_FOR_DELIVERY, DELIVERED
}
