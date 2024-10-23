package org.kaistinea.generation.config;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RedisCleanup{
    private final RedisTemplate<String, Object> redisTemplate;

    @PreDestroy
    public void cleanUp() {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        if (connectionFactory instanceof LettuceConnectionFactory) {
            LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) connectionFactory;
            if (!lettuceConnectionFactory.isRunning()) {
                lettuceConnectionFactory.start();
            }
        }
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }
}
