package org.fooddelivery.deliveryservice.delivery.event.consumer;

import org.fooddelivery.models.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

	@KafkaListener(topics = "orders", groupId = "delivery-service")
	public void consumeOrderStatusChanged(OrderEvent event) {
		if ("READY_FOR_PICKUP".equals(event.getNewStatus())) {
			// trigger assignment logic
		}
	}

}
