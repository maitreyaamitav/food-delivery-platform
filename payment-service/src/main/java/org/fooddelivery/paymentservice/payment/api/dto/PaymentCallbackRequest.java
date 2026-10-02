package org.fooddelivery.paymentservice.payment.api.dto;

import lombok.Data;

@Data
public class PaymentCallbackRequest {

	private Long paymentId;
    private String providerStatus;
    private String providerReference;
}
