package org.kaistinea.notification.mapper;

import org.kaistinea.notification.dto.NotificationDTO;
import org.kaistinea.notification.entity.NotificationEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface NotificationMapper {
    NotificationEntity toEntity(NotificationDTO notification);

    NotificationDTO toDto(NotificationEntity notification);
}
