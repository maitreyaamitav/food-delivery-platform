package org.fooddelivery.paymentservice.payment.api;

import org.fooddelivery.paymentservice.payment.api.dto.PaymentCallbackRequest;
import org.fooddelivery.paymentservice.payment.api.dto.PaymentRequest;
import org.fooddelivery.paymentservice.payment.api.dto.PaymentResponse;
import org.fooddelivery.paymentservice.payment.persistent.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> initiatePayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.initiatePayment(request));
    }

    @PostMapping("/callback")
    public ResponseEntity<PaymentResponse> handleCallback(@RequestBody PaymentCallbackRequest callback) {
        return ResponseEntity.ok(paymentService.handleCallback(callback));
    }
}
