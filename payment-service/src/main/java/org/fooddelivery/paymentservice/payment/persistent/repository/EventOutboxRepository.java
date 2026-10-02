package org.fooddelivery.paymentservice.payment.persistent.repository;

import org.fooddelivery.paymentservice.payment.persistent.domain.EventOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventOutboxRepository extends JpaRepository<EventOutbox, Long> {}
