package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationRequest;

public interface PushService {
    void sendPushNotification(NotificationRequest notification);
}
