package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationDTO;
import org.kaistinea.notification.dto.NotificationRequest;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotificationsByUserId(Long userId);

    void sendNotification(NotificationRequest notificationRequest);
}
