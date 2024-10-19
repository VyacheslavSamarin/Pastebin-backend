package org.kaistinea.paste.mapper;

import org.kaistinea.paste.dto.CreatePasteRequest;
import org.kaistinea.paste.entity.PasteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CreatePasteRequestMapper {
    PasteEntity toEntity(CreatePasteRequest createPasteRequest);

}
