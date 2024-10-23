package org.kaistinea.notification.service;

import lombok.RequiredArgsConstructor;
import org.kaistinea.notification.dto.NotificationDTO;
import org.kaistinea.notification.dto.NotificationRequest;
import org.kaistinea.notification.mapper.NotificationMapper;
import org.kaistinea.notification.mapper.NotificationRequestMapper;
import org.kaistinea.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final NotificationRequestMapper notificationRequestMapper;
    private final NotificationSenderFactory notificationSenderFactory;

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        return notificationRepository.findAllByUserId(userId).stream().map(notificationMapper::toDto).toList();
    }

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {
        NotificationSender sender = notificationSenderFactory.getNotificationSender(notificationRequest.getType());
        sender.sendMessage(notificationRequest);

        notificationRepository.save(notificationRequestMapper.toEntity(notificationRequest));

    }
}
