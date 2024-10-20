package org.kaistinea.generation.mapper;

import org.kaistinea.generation.dto.KeyDTO;
import org.kaistinea.generation.entity.KeyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
     componentModel = "spring"
)
public interface KeyMapper {
    @Mapping(target = "key", source = "uniqueKey")
    KeyDTO toDTO(KeyEntity key);
}
