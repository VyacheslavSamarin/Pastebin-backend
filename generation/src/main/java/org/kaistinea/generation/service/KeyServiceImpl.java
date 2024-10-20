package org.kaistinea.generation.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.generation.dto.KeyDTO;
import org.kaistinea.generation.entity.KeyEntity;
import org.kaistinea.generation.mapper.KeyMapper;
import org.kaistinea.generation.repository.KeyRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyServiceImpl implements KeyService {
    private final KeyRepository keyRepository;
    private final KeyMapper keyMapper;

    @Override
    @Scheduled(fixedRate = 5000)
    public void generateKeys() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer buffer = ByteBuffer.wrap(Base64.getEncoder().encode(uuid.toString().getBytes()));
        KeyEntity keyEntity = new KeyEntity();
        keyEntity.setUniqueKey(Base64.getEncoder().encodeToString(buffer.array()));
        keyRepository.save(keyEntity);
    }

    @Override
    @Transactional
    public KeyDTO getKey() {
        KeyEntity key = keyRepository.findFirstByIsAvailableTrue();
        key.setIsAvailable(false);
        return keyMapper.toDTO(key);
    }

    @Override
    public List<KeyDTO> getAllKeys() {
        return keyRepository.findAll().stream().map(keyMapper::toDTO).toList();
    }
}
