package org.fooddelivery.orderservice.order.api.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
	
	private Long orderId;
    private BigDecimal totalAmount;
    private String status;
    private List<OrderItemResponse> items;

}

