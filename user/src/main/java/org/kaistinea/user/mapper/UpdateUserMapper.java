package org.kaistinea.user.mapper;

import org.kaistinea.user.dto.UpdateUserRequest;
import org.kaistinea.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring"
)
public interface UpdateUserMapper {
    void updateUser(@MappingTarget UserEntity userEntity, UpdateUserRequest updateUserRequest);
}
