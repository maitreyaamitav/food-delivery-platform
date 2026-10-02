package org.fooddelivery.notificationservice.notification.persistent.repository;

import org.fooddelivery.notificationservice.notification.persistent.domain.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
