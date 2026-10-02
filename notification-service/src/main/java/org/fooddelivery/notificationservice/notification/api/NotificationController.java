package org.fooddelivery.notificationservice.notification.api;

import org.fooddelivery.notificationservice.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	private final NotificationService notificationService;

	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping
	public ResponseEntity<String> sendManualNotification(@RequestParam String recipient, @RequestParam String message) {
		notificationService.sendNotification("MANUAL", recipient, message);
		return ResponseEntity.ok("Notification sent");
	}
}
