package org.kaistinea.generation.repository;

import org.kaistinea.generation.entity.KeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaKeyRepository extends JpaRepository<KeyEntity, Long> {
    Optional<KeyEntity> findFirstByIsAvailableTrue();
}
