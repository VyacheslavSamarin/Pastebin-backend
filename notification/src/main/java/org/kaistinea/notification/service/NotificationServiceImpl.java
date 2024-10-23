package org.kaistinea.notification.service;

import org.kaistinea.notification.dto.NotificationDTO;
import org.kaistinea.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {

    }
}
