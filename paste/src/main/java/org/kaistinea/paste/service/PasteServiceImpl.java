package org.kaistinea.paste.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.paste.dto.CreatePasteRequest;
import org.kaistinea.paste.dto.PasteDTO;
import org.kaistinea.paste.dto.TagDTO;
import org.kaistinea.paste.dto.UpdatePasteRequest;
import org.kaistinea.paste.entity.PasteEntity;
import org.kaistinea.paste.entity.TagEntity;
import org.kaistinea.paste.mapper.CreatePasteRequestMapper;
import org.kaistinea.paste.mapper.PasteMapper;
import org.kaistinea.paste.mapper.TagMapper;
import org.kaistinea.paste.mapper.UpdatePasteRequestMapper;
import org.kaistinea.paste.repository.PasteRepository;
import org.kaistinea.paste.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PasteServiceImpl implements PasteService {
    private final PasteRepository pasteRepository;
    private final PasteMapper pasteMapper;
    private final UpdatePasteRequestMapper updatePasteRequestMapper;
    private final CreatePasteRequestMapper createPasteRequestMapper;
    private final TagMapper tagMapper;
    private final TagRepository tagRepository;

    @Override
    public void deletePaste(Long id) {
        if (pasteRepository.existsById(id)) {
            pasteRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public PasteDTO getPaste(Long id) {
        return pasteMapper.toDTO(pasteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<PasteDTO> getPastes() {
        return pasteRepository.findAll().stream().map(pasteMapper::toDTO).toList();
    }

    @Override
    public PasteDTO createPaste(CreatePasteRequest pasteDTO) {
        PasteEntity entity = createPasteRequestMapper.toEntity(pasteDTO);
        if (pasteDTO.getTags() != null && !pasteDTO.getTags().isEmpty()) {
            List<TagEntity> tagEntities = new ArrayList<>();
            for (TagDTO tagDTO : pasteDTO.getTags()) {
                TagEntity tagEntity = tagMapper.toEntity(tagDTO);
                if (!tagRepository.existsByName(tagDTO.getName())) {
                    tagEntity = tagRepository.save(tagEntity);
                }
                tagEntities.add(tagEntity);
            }
            entity.setTagEntities(tagEntities);
        }
        return pasteMapper.toDTO(pasteRepository.save(entity));
    }



    @Override
    @Transactional
    public PasteDTO updatePaste(UpdatePasteRequest pasteDTO, Long id) {
        PasteEntity pasteEntity = pasteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatePasteRequestMapper.updatePasteEntity(pasteDTO, pasteEntity);
        return pasteMapper.toDTO(pasteEntity);
    }
}
