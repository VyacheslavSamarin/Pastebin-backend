package org.kaistinea.notification.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.kaistinea.common.enums.NotificationType;

import java.time.OffsetDateTime;

@Table(name = "notification")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private NotificationType type;

    private String content;

    private OffsetDateTime sendAt = OffsetDateTime.now();

}
