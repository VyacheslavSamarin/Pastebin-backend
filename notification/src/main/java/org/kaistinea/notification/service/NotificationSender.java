package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationRequest;

public interface NotificationSender {
    void sendMessage(NotificationRequest notificationRequest);
}
