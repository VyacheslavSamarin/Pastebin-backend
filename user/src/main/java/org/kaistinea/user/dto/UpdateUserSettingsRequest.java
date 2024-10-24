package org.kaistinea.user.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserSettingsRequest {
    private Boolean notificationsEnabled;

    private Boolean darkMode ;

    private String language;
}
