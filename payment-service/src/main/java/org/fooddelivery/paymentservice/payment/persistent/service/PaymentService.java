package org.fooddelivery.paymentservice.payment.persistent.service;

import java.time.Instant;

import org.fooddelivery.paymentservice.payment.api.dto.PaymentCallbackRequest;
import org.fooddelivery.paymentservice.payment.api.dto.PaymentRequest;
import org.fooddelivery.paymentservice.payment.api.dto.PaymentResponse;
import org.fooddelivery.paymentservice.payment.persistent.domain.Payment;
import org.fooddelivery.paymentservice.payment.persistent.repository.PaymentRepository;

import jakarta.transaction.Transactional;

public class PaymentService {

	private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public PaymentResponse initiatePayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setStatus("INITIATED");
        payment.setCreatedAt(Instant.now());
        payment.setUpdatedAt(Instant.now());
        paymentRepository.save(payment);

        return toResponse(payment);
    }

    @Transactional
    public PaymentResponse handleCallback(PaymentCallbackRequest callback) {
        Payment payment = paymentRepository.findById(callback.getPaymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus(callback.getProviderStatus());
        payment.setUpdatedAt(Instant.now());
        paymentRepository.save(payment);

        return toResponse(payment);
    }

    private PaymentResponse toResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setOrderId(payment.getOrderId());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        return response;
    }
	
}
