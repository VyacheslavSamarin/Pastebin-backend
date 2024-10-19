package org.kaistinea.paste.mapper;

import org.kaistinea.paste.dto.TagDTO;
import org.kaistinea.paste.entity.TagEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface TagMapper {
    TagEntity toEntity(TagDTO tag);
    TagDTO toDto(TagEntity tag);

    void updateTagEntity(@MappingTarget TagEntity tag, TagDTO tagDTO);
}
