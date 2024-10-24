package org.kaistinea.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;

@Jacksonized
@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotNull
    private Long id;

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    private String avatar;

    private String bio;

    @NotNull
    private Boolean isPublic;

    @NotNull
    private OffsetDateTime creationDate;

    @NotNull
    private OffsetDateTime updatedDate;

    @NotNull
    private UserSettingsDTO userSettings;

}
