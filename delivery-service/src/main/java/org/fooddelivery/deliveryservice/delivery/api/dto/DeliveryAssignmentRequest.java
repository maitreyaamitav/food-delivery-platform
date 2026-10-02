package org.fooddelivery.deliveryservice.delivery.api.dto;

import lombok.Data;

@Data
public class DeliveryAssignmentRequest {

	private Long orderId;
    private Long partnerId;
}
