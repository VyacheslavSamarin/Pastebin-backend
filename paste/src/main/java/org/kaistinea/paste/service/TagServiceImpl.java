package org.kaistinea.paste.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.paste.dto.TagDTO;
import org.kaistinea.paste.entity.TagEntity;
import org.kaistinea.paste.mapper.TagMapper;
import org.kaistinea.paste.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;


    @Override
    public void deleteTag(Long tag) {
        if (tagRepository.existsById(tag)) {
            tagRepository.deleteById(tag);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public TagDTO saveTag(TagDTO tag) {
        return tagMapper.toDto(tagRepository.save(tagMapper.toEntity(tag)));
    }

    @Override
    public TagDTO getTag(Long id) {
        return tagMapper.toDto(tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<TagDTO> getTags() {
        return tagRepository.findAll().stream().map(tagMapper::toDto).toList();
    }

    @Override
    @Transactional
    public TagDTO updateTag(TagDTO tag, Long id) {
        TagEntity tagEntity = tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        tagMapper.updateTagEntity(tagEntity, tag);
        return tagMapper.toDto(tagEntity);
    }
}
