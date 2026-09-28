package org.fooddelivery.orderservice.order.persistent.repository;

import org.fooddelivery.orderservice.order.persistent.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
