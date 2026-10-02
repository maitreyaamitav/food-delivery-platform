package org.fooddelivery.paymentservice.payment.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentResponse {

	private Long paymentId;
	private Long orderId;
	private BigDecimal amount;
	private String status;
}
