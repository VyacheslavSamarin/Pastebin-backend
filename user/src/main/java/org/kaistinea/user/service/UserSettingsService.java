package org.kaistinea.user.service;

import org.kaistinea.user.dto.UpdateUserSettingsRequest;

public interface UserSettingsService {
    void updateUserSettings(Long userId, UpdateUserSettingsRequest request);
}
