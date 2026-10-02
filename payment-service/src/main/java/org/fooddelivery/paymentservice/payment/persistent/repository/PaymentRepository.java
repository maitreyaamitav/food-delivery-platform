package org.fooddelivery.paymentservice.payment.persistent.repository;

import org.fooddelivery.paymentservice.payment.persistent.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}