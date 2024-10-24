package org.kaistinea.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@Table(name = "userProfile")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    private String avatar = "https://resizing.flixster.com/6eh6B5OkYzbBp3RPy1_sR0_JcO8=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzcyY2MxYzhiLTRkZTctNDgyYy04YTZiLWQ4ZTJkZDFjNDUyNS5qcGc=";

    private String bio = "New user";

    private Boolean isPublic = true;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    @UpdateTimestamp
    private OffsetDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    private UserSettingsEntity userSettings;

}
