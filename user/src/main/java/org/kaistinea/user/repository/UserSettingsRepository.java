package org.kaistinea.user.repository;

import org.kaistinea.user.entity.UserEntity;
import org.kaistinea.user.entity.UserSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettingsEntity, Long> {
    Optional<UserSettingsEntity> findByUser(UserEntity user);
}
