package org.fooddelivery.orderservice.order.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

	private Long customerId;
	private Long restaurantId;
	private List<OrderItemRequest> items;
}
