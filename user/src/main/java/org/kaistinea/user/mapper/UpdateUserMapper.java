package org.kaistinea.user.mapper;

import org.kaistinea.user.dto.UpdateUserRequest;
import org.kaistinea.user.entity.UserEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE

)
public interface UpdateUserMapper {
    void updateUser(@MappingTarget UserEntity userEntity, UpdateUserRequest updateUserRequest);
}
