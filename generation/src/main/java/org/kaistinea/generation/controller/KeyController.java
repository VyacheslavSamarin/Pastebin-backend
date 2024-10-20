package org.kaistinea.generation.controller;

import lombok.RequiredArgsConstructor;
import org.kaistinea.generation.dto.KeyDTO;
import org.kaistinea.generation.service.KeyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/keys")
@RequiredArgsConstructor
public class KeyController {
    private final KeyService keyService;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<List<KeyDTO>> getALlKeys() {
        return ResponseEntity.ok(keyService.getAllKeys());
    }
}
