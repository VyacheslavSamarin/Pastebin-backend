package org.kaistinea.notification.mapper;

import org.kaistinea.notification.dto.NotificationRequest;
import org.kaistinea.notification.entity.NotificationEntity;
import org.mapstruct.Mapper;

@Mapper(
      componentModel = "spring"
)
public interface NotificationRequestMapper {
    NotificationEntity toEntity(NotificationRequest notificationRequest);
}
