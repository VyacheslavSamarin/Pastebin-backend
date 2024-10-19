package org.kaistinea.paste.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kaistinea.paste.dto.TagDTO;
import org.kaistinea.paste.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tags")
public class TagController {
    private final TagService tagService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
        method = RequestMethod.POST
    )
    public ResponseEntity<TagDTO> saveTag(@Valid @RequestBody TagDTO tagDTO) {
        return ResponseEntity.ok(tagService.saveTag(tagDTO));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<TagDTO> getTag(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.getTag(id));
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<List<TagDTO>> getAllTags() {
        return ResponseEntity.ok(tagService.getTags());
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT
    )
    public ResponseEntity<TagDTO> updateTag(@Valid @RequestBody TagDTO tagDTO, @PathVariable Long id) {
        return ResponseEntity.ok(tagService.updateTag(tagDTO, id));
    }
}
