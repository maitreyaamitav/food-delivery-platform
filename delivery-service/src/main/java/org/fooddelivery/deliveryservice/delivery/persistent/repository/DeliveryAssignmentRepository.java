package org.fooddelivery.deliveryservice.delivery.persistent.repository;

import org.fooddelivery.deliveryservice.delivery.persistent.domain.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, Long> {}
