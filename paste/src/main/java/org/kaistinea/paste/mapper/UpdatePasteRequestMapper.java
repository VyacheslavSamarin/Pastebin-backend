package org.kaistinea.paste.mapper;

import org.kaistinea.paste.dto.UpdatePasteRequest;
import org.kaistinea.paste.entity.PasteEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {TagMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UpdatePasteRequestMapper {
    void updatePasteEntity(UpdatePasteRequest updatePasteRequest, @MappingTarget PasteEntity pasteEntity);
}
