package org.fooddelivery.deliveryservice.delivery.persistent.repository;

import org.fooddelivery.deliveryservice.delivery.persistent.domain.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {
}