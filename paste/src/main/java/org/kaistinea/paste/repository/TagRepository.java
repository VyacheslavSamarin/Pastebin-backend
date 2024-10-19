package org.kaistinea.paste.repository;

import org.kaistinea.paste.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
    boolean existsByName(String name);

    TagEntity findByName(String name);
}
