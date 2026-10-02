package org.fooddelivery.paymentservice.payment.persistent.repository;

import org.fooddelivery.paymentservice.payment.persistent.domain.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {}
