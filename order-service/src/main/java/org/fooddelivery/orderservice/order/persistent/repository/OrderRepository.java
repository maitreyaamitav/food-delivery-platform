package org.fooddelivery.orderservice.order.persistent.repository;

import org.fooddelivery.orderservice.order.persistent.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
