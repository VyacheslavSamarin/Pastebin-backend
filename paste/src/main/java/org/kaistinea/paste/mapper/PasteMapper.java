package org.kaistinea.paste.mapper;

import org.kaistinea.paste.dto.PasteDTO;
import org.kaistinea.paste.entity.PasteEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {TagMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface PasteMapper {
    @Mapping(target = "tagEntities", source = "tags")
    PasteEntity toEntity(PasteDTO pasteDTO);
    @Mapping(target = "tags", source = "tagEntities")
    PasteDTO toDTO(PasteEntity pasteEntity);
}
