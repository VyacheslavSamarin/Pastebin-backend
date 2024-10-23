package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationRequest;

public interface EmailService {
    void sendEmailNotification(NotificationRequest notification);
}
