package org.kaistinea.user.controller;

import lombok.RequiredArgsConstructor;
import org.kaistinea.user.dto.UpdateUserSettingsRequest;
import org.kaistinea.user.service.UserSettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/settings")
public class UserSettingsController {
    private final UserSettingsService userSettingsService;

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/{userId}"
    )
    public ResponseEntity<Void> updateUserSettings(@PathVariable Long userId, @RequestBody UpdateUserSettingsRequest request) {
        userSettingsService.updateUserSettings(userId, request);
        return ResponseEntity.noContent().build();
    }
}
