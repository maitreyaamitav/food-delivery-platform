package org.fooddelivery.deliveryservice.delivery.api.dto;

import lombok.Data;

@Data
public class DeliveryResponse {

	private Long assignmentId;
	private Long orderId;
	private Long partnerId;
	private String status;
}
