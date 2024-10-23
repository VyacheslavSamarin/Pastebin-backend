package org.kaistinea.notification.controller;

import lombok.RequiredArgsConstructor;
import org.kaistinea.notification.dto.NotificationDTO;
import org.kaistinea.notification.dto.NotificationRequest;
import org.kaistinea.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{userId}"
    )
    public ResponseEntity<List<NotificationDTO>> getAllNotificationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userId));
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.noContent().build();
    }
}
