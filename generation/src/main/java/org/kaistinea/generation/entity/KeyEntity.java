package org.kaistinea.generation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "keys")
//@RedisHash(value = "KeyEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class KeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uniqueKey;

    @Builder.Default
    private Boolean isAvailable = true;
}
