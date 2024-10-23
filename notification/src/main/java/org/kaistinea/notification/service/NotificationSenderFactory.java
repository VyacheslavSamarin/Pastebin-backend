package org.kaistinea.notification.service;

import lombok.RequiredArgsConstructor;
import org.kaistinea.common.enums.NotificationType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NotificationSenderFactory {
    private final Map<NotificationType, NotificationSender> notificationSenders = new HashMap<NotificationType, NotificationSender>();

    public NotificationSenderFactory(List<NotificationSender> senders){
        for (NotificationSender sender : senders) {
            if (sender instanceof EmailNotificationSender) {
                notificationSenders.put(NotificationType.EMAIL, sender);
            }
            if (sender instanceof WebsocketNotificationSender) {
                notificationSenders.put(NotificationType.WEBSOCKET, sender);
            }
            if (sender instanceof PushNotificationSender) {
                notificationSenders.put(NotificationType.PUSH, sender);
            }
        }
    }

    public NotificationSender getNotificationSender(NotificationType type) {
        return notificationSenders.get(type);
    }
}
