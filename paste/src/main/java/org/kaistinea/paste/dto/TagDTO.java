package org.kaistinea.paste.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder(toBuilder = true)
public class TagDTO {
    @NotNull
    private String name;
}
