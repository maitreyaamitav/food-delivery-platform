package org.fooddelivery.notificationservice.notification.service;

import java.time.Instant;

import org.fooddelivery.notificationservice.notification.persistent.domain.NotificationLog;
import org.fooddelivery.notificationservice.notification.persistent.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationLogRepository logRepository;

    public NotificationService(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void sendNotification(String eventType, String recipient, String message) {
        // Here you’d integrate with email/SMS/push provider
        System.out.println("Sending notification to " + recipient + ": " + message);

        NotificationLog log = new NotificationLog();
        log.setEventType(eventType);
        log.setRecipient(recipient);
        log.setMessage(message);
        log.setCreatedAt(Instant.now());
        logRepository.save(log);
    }
}

