package org.kaistinea.paste.service;

import org.kaistinea.paste.dto.CreatePasteRequest;
import org.kaistinea.paste.dto.PasteDTO;
import org.kaistinea.paste.dto.UpdatePasteRequest;

import java.util.List;

public interface PasteService {
    void deletePaste(Long id);

    PasteDTO getPaste(Long id);

    List<PasteDTO> getPastes();

    PasteDTO createPaste(CreatePasteRequest pasteDTO);

    PasteDTO updatePaste(UpdatePasteRequest pasteDTO, Long id);
}
