package org.fooddelivery.orderservice.order.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.fooddelivery.orderservice.order.api.dto.OrderItemRequest;
import org.fooddelivery.orderservice.order.api.dto.OrderItemResponse;
import org.fooddelivery.orderservice.order.api.dto.OrderRequest;
import org.fooddelivery.orderservice.order.api.dto.OrderResponse;
import org.fooddelivery.orderservice.order.exception.OrderNotFoundException;
import org.fooddelivery.orderservice.order.persistent.domain.Order;
import org.fooddelivery.orderservice.order.persistent.domain.OrderItem;
import org.fooddelivery.orderservice.order.persistent.domain.OrderStatusHistory;
import org.fooddelivery.orderservice.order.persistent.repository.OrderRepository;
import org.fooddelivery.orderservice.order.persistent.repository.OrderStatusHistoryRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderStatusHistoryRepository historyRepository;


	public OrderResponse createOrder(OrderRequest request) {
		Order order = new Order();
		order.setCustomerId(request.getCustomerId());
		order.setRestaurantId(request.getRestaurantId());
		order.setStatus("CREATED");

		BigDecimal total = request.getItems().stream().map(OrderItemRequest::getPrice).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		order.setTotalAmount(total);

		// map items
		List<OrderItem> items = request.getItems().stream().map(req -> {
			OrderItem item = new OrderItem();
			item.setMenuItemId(req.getMenuItemId());
			item.setName(req.getName());
			item.setPrice(req.getPrice());
			item.setOrder(order);
			return item;
		}).collect(Collectors.toList());
		order.setItems(items);

		orderRepository.save(order);

		// status history
		OrderStatusHistory history = new OrderStatusHistory();
		history.setOrder(order);
		history.setNewStatus("CREATED");
		historyRepository.save(history);

		return toResponse(order);
	}

	public OrderResponse getOrder(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		return toResponse(order);
	}

	public void updateStatus(Long id, String newStatus) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		String oldStatus = order.getStatus();
		order.setStatus(newStatus);
		order.setUpdatedAt(LocalDateTime.now());
		orderRepository.save(order);

		OrderStatusHistory history = new OrderStatusHistory();
		history.setOrder(order);
		history.setOldStatus(oldStatus);
		history.setNewStatus(newStatus);
		historyRepository.save(history);
	}

	private OrderResponse toResponse(Order order) {
		OrderResponse response = new OrderResponse();
		response.setOrderId(order.getOrderId());
		response.setTotalAmount(order.getTotalAmount());
		response.setStatus(order.getStatus());
		response.setItems(order.getItems().stream().map(item -> {
			OrderItemResponse ir = new OrderItemResponse();
			ir.setMenuItemId(item.getMenuItemId());
			ir.setName(item.getName());
			ir.setPrice(item.getPrice());
			return ir;
		}).collect(Collectors.toList()));
		return response;
	}
}
