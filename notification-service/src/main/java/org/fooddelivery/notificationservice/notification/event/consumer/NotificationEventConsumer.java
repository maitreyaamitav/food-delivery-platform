package org.fooddelivery.notificationservice.notification.event.consumer;

import org.fooddelivery.models.event.DeliveryEvent;
import org.fooddelivery.models.event.OrderEvent;
import org.fooddelivery.models.event.PaymentEvent;
import org.fooddelivery.notificationservice.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventConsumer {
	private final NotificationService notificationService;

	public NotificationEventConsumer(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@KafkaListener(topics = { "orders", "payments", "deliveries" }, groupId = "notification-service")
	public void consumeEvents(Object event) {
		// In practice, you’d deserialize into specific event types (OrderEvent,
		// PaymentEvent, DeliveryEvent)
		// For simplicity, treat as generic JSON and route accordingly
		if (event instanceof OrderEvent orderEvent) {
			notificationService.sendNotification("ORDER", "customer@example.com",
					"Your order " + orderEvent.getOrderId() + " is now " + orderEvent.getNewStatus());
		} else if (event instanceof PaymentEvent paymentEvent) {
			notificationService.sendNotification("PAYMENT", "customer@example.com",
					"Payment " + paymentEvent.getStatus() + " for order " + paymentEvent.getOrderId());
		} else if (event instanceof DeliveryEvent deliveryEvent) {
			notificationService.sendNotification("DELIVERY", "customer@example.com",
					"Delivery status: " + deliveryEvent.getStatus());
		}
	}
}
