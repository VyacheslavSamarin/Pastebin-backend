package org.kaistinea.generation.service;

import org.kaistinea.generation.dto.KeyDTO;

import java.util.List;

public interface KeyService {
    void generateKeys();

    KeyDTO getKey();

    List<KeyDTO> getAllKeys();
}
