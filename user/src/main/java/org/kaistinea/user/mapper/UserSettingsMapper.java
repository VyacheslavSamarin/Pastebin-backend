package org.kaistinea.user.mapper;

import org.kaistinea.user.dto.UserSettingsDTO;
import org.kaistinea.user.entity.UserSettingsEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserSettingsMapper {
    UserSettingsEntity toEntity(UserSettingsDTO dto);
    UserSettingsDTO toDto(UserSettingsEntity entity);
}
