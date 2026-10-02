package org.fooddelivery.paymentservice.payment.event.publisher;

import org.fooddelivery.models.event.PaymentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class PaymentEventPublisher {

	
	private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentEventPublisher(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPaymentSucceeded(PaymentEvent event) {
        kafkaTemplate.send("payments", event);
    }

    public void publishPaymentFailed(PaymentEvent event) {
        kafkaTemplate.send("payments", event);
    }
}
