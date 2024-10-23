package org.kaistinea.paste.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kaistinea.paste.dto.CreatePasteRequest;
import org.kaistinea.paste.dto.PasteDTO;
import org.kaistinea.paste.dto.UpdatePasteRequest;
import org.kaistinea.paste.service.PasteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/pastes")
@RequiredArgsConstructor
public class PasteController {
    private final PasteService pasteService;

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public ResponseEntity<Void> deletePaste(@PathVariable Long id) {
        pasteService.deletePaste(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<List<PasteDTO>> getPastes() {
        return ResponseEntity.ok(pasteService.getPastes());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public ResponseEntity<PasteDTO> getPasteById(@PathVariable Long id) {
        return ResponseEntity.ok(pasteService.getPaste(id));
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<PasteDTO> addPaste(@Valid @RequestBody CreatePasteRequest pasteDTO) {
        return ResponseEntity.ok(pasteService.createPaste(pasteDTO));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public ResponseEntity<PasteDTO> updatePaste(@Valid @RequestBody UpdatePasteRequest pasteDTO, @PathVariable Long id) {
        return ResponseEntity.ok(pasteService.updatePaste(pasteDTO, id));
    }
}
