package org.kaistinea.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.user.dto.UpdateUserSettingsRequest;
import org.kaistinea.user.entity.UserEntity;
import org.kaistinea.user.entity.UserSettingsEntity;
import org.kaistinea.user.mapper.UpdateUserSettingsMapper;
import org.kaistinea.user.mapper.UserSettingsMapper;
import org.kaistinea.user.repository.UserRepository;
import org.kaistinea.user.repository.UserSettingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserSettingsServiceImpl implements UserSettingsService {
    private final UserSettingsRepository userSettingsRepository;
    private final UserSettingsMapper userSettingsMapper;
    private final UpdateUserSettingsMapper updateUserSettingsMapper;
    private final UserRepository userRepository;;

    @Override
    @Transactional
    public void updateUserSettings(Long userId, UpdateUserSettingsRequest request) {
        UserEntity entity = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        UserSettingsEntity settingsEntity = userSettingsRepository.findByUser(entity).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateUserSettingsMapper.updateUserSettings(settingsEntity, request);
    }
}
