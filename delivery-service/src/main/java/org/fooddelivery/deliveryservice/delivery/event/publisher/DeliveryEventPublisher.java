package org.fooddelivery.deliveryservice.delivery.event.publisher;

import org.fooddelivery.models.event.DeliveryEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeliveryEventPublisher {
    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    public DeliveryEventPublisher(KafkaTemplate<String, DeliveryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishDeliveryAssigned(DeliveryEvent event) {
        kafkaTemplate.send("deliveries", event);
    }

    public void publishDeliveryStatusUpdated(DeliveryEvent event) {
        kafkaTemplate.send("deliveries", event);
    }
}
