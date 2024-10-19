package org.kaistinea.paste.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tag")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq", sequenceName = "tag_sequence", allocationSize = 10, initialValue = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

}
