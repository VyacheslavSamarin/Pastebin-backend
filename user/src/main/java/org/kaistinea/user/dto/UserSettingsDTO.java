package org.kaistinea.user.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.kaistinea.user.entity.UserEntity;

@Jacksonized
@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsDTO {
    @NotNull
    private Long id;

    @NotNull
    private Boolean notificationsEnabled;

    @NotNull
    private Boolean darkMode ;

    @NotNull
    private String language;
}
