package org.kaistinea.notification.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.kaistinea.common.enums.NotificationType;

@Jacksonized
@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    @NotNull
    private Long userId;

    @NotNull
    private NotificationType type;

    private String content;

}
