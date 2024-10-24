package org.kaistinea.user.mapper;

import org.kaistinea.user.dto.UserDTO;
import org.kaistinea.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = UserSettingsMapper.class
)
public interface UserMapper {
    UserEntity toEntity(UserDTO userDTO);

    UserDTO toDto(UserEntity userEntity);
}
