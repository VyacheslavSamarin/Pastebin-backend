package org.kaistinea.paste.repository;

import org.kaistinea.paste.entity.PasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends JpaRepository<PasteEntity, Long> {
}
