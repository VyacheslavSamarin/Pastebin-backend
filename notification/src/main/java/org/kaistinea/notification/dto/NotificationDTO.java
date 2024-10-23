package org.kaistinea.notification.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.kaistinea.common.enums.NotificationType;

import java.time.OffsetDateTime;

@Jacksonized
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    @NotNull
    private Long id;
    @NotNull
    private Long userId;

    private String content;
    @NotNull
    private NotificationType type;
    @NotNull
    private OffsetDateTime createdAt;
}
