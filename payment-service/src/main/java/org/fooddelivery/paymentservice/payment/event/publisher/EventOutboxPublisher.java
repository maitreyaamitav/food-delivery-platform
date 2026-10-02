package org.fooddelivery.paymentservice.payment.event.publisher;

import org.fooddelivery.models.event.PaymentEvent;
import org.fooddelivery.paymentservice.payment.persistent.repository.EventOutboxRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EventOutboxPublisher {

	private final EventOutboxRepository outboxRepository;
	private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

	public EventOutboxPublisher(EventOutboxRepository outboxRepository, KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
		this.outboxRepository = outboxRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Transactional
	public void publishPendingEvents() {
		outboxRepository.findAll().stream().filter(e -> "PENDING".equals(e.getStatus())).forEach(event -> {
			kafkaTemplate.send("payments", event.getPayload());
			event.setStatus("PUBLISHED");
			event.setPublishedAt(java.time.Instant.now());
			outboxRepository.save(event);
		});
	}
}
