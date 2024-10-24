package org.kaistinea.user.mapper;

import org.kaistinea.user.dto.UpdateUserSettingsRequest;
import org.kaistinea.user.entity.UserSettingsEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS

)
public interface UpdateUserSettingsMapper {
    void updateUserSettings(@MappingTarget UserSettingsEntity userSettingsEntity, UpdateUserSettingsRequest updateUserSettingsRequest);
}
