package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationSender implements NotificationSender {
    @Override
    public void sendMessage(NotificationRequest notificationRequest) {

    }
}
