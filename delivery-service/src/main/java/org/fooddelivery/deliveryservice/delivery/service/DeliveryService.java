package org.fooddelivery.deliveryservice.delivery.service;

import java.time.Instant;

import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryAssignmentRequest;
import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryResponse;
import org.fooddelivery.deliveryservice.delivery.api.dto.DeliveryStatusUpdateRequest;
import org.fooddelivery.deliveryservice.delivery.persistent.domain.DeliveryAssignment;
import org.fooddelivery.deliveryservice.delivery.persistent.repository.DeliveryAssignmentRepository;
import org.fooddelivery.deliveryservice.delivery.persistent.repository.DeliveryPartnerRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DeliveryService {
    private final DeliveryAssignmentRepository assignmentRepo;
    private final DeliveryPartnerRepository partnerRepo;

    public DeliveryService(DeliveryAssignmentRepository assignmentRepo,
                           DeliveryPartnerRepository partnerRepo) {
        this.assignmentRepo = assignmentRepo;
        this.partnerRepo = partnerRepo;
    }

    @Transactional
    public DeliveryResponse assignPartner(DeliveryAssignmentRequest request) {
        DeliveryAssignment assignment = new DeliveryAssignment();
        assignment.setOrderId(request.getOrderId());
        assignment.setPartnerId(request.getPartnerId());
        assignment.setStatus("ASSIGNED");
        assignment.setCreatedAt(Instant.now());
        assignment.setUpdatedAt(Instant.now());
        assignmentRepo.save(assignment);

        return toResponse(assignment);
    }

    @Transactional
    public DeliveryResponse updateStatus(DeliveryStatusUpdateRequest request) {
        DeliveryAssignment assignment = assignmentRepo.findById(request.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus(request.getNewStatus());
        assignment.setUpdatedAt(Instant.now());
        assignmentRepo.save(assignment);

        return toResponse(assignment);
    }

    private DeliveryResponse toResponse(DeliveryAssignment assignment) {
        DeliveryResponse response = new DeliveryResponse();
        response.setAssignmentId(assignment.getId());
        response.setOrderId(assignment.getOrderId());
        response.setPartnerId(assignment.getPartnerId());
        response.setStatus(assignment.getStatus());
        return response;
    }
}

