package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendMessage(NotificationRequest notificationRequest) {

    }
}
