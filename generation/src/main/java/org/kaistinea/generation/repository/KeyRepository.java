package org.kaistinea.generation.repository;

import org.kaistinea.generation.entity.KeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<KeyEntity, Long> {
}
