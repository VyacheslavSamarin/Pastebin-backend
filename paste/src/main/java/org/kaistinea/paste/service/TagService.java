package org.kaistinea.paste.service;

import org.kaistinea.paste.dto.TagDTO;

import java.util.List;

public interface TagService {
    void deleteTag(Long id);

    TagDTO saveTag(TagDTO tag);

    TagDTO getTag(Long id);

    List<TagDTO> getTags();

    TagDTO updateTag(TagDTO tag, Long id);
}
