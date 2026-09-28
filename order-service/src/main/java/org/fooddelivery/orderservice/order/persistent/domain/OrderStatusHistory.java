package org.fooddelivery.orderservice.order.persistent.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_status_history", schema="food_delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderStatusHistory {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long historyId;

	    private String oldStatus;
	    private String newStatus;
	    private LocalDateTime changedAt = LocalDateTime.now();

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;
	
}
