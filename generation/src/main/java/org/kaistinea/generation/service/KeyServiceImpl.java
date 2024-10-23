package org.kaistinea.generation.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.generation.dto.KeyDTO;
import org.kaistinea.generation.entity.KeyEntity;
import org.kaistinea.generation.mapper.KeyMapper;
import org.kaistinea.generation.repository.JpaKeyRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyServiceImpl implements KeyService {
    private final JpaKeyRepository keyRepository;
    private final KeyMapper keyMapper;
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    @Scheduled(fixedRate = 5000)
    public void generateKeys() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer buffer = ByteBuffer.wrap(Base64.getEncoder().encode(uuid.toString().getBytes()));
        String uniqueKey = Base64.getEncoder().encodeToString(buffer.array());
        KeyEntity keyEntity = new KeyEntity();
        keyEntity.setUniqueKey(uniqueKey);
        keyRepository.save(keyEntity);

        redisTemplate.opsForList().rightPush("keys", uniqueKey);
    }

    @Override
    @Transactional
    public KeyDTO getKey() {
        String keyFromRedis = redisTemplate.opsForList().leftPop("keys");

        if (keyFromRedis == null) {
            KeyEntity key = keyRepository.findFirstByIsAvailableTrue()
                    .orElseThrow(() -> new RuntimeException("Key not found"));
            key.setIsAvailable(false);
            return keyMapper.toDTO(key);
        }

        return new KeyDTO(keyFromRedis);
    }

    @Override
    public List<KeyDTO> getAllKeys() {
        return keyRepository.findAll().stream().map(keyMapper::toDTO).toList();
    }
}
