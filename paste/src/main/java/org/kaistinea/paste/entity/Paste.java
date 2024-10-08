package org.kaistinea.paste.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "Paste")
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Paste{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paste_seq")
    @SequenceGenerator(name = "paste_seq", sequenceName = "paste_sequence", allocationSize = 50, initialValue = 1)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private Long authorId;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    private OffsetDateTime expirationDate;

    @Column(nullable = false)
    private Boolean isPublic;

    private Long viewCount = 0L;

    @ManyToMany
    private List<Tag> tags;


}
