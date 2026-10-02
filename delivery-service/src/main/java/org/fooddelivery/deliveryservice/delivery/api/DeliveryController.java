package org.fooddelivery.deliveryservice.delivery.api;

import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryAssignmentRequest;
import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryResponse;
import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryStatusUpdateRequest;
import org.fooddelivery.deliveryservice.delivery.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/assignments")
    public ResponseEntity<DeliveryResponse> assignPartner(@RequestBody DeliveryAssignmentRequest request) {
        return ResponseEntity.ok(deliveryService.assignPartner(request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DeliveryResponse> updateStatus(@PathVariable Long id,
                                                         @RequestBody DeliveryStatusUpdateRequest request) {
        request.setAssignmentId(id);
        return ResponseEntity.ok(deliveryService.updateStatus(request));
    }
}
