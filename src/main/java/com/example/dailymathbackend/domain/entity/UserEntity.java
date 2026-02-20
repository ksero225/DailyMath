package com.example.dailymathbackend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "app_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "userEmail", unique = true, nullable = false, length = 320)
    private String userEmail;

    @Column(name = "userLogin", unique = true, nullable = false, length = 320)
    private String userLogin;

    @Column(name = "userPasswordHash", unique = true, nullable = false, length = 320)
    private String userPasswordHash;

    @Column(name = "userName", unique = true, nullable = false, length = 320)
    private String userName;

    @Column(name = "userAccountEnabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "userAccountCreatedDate", nullable = false)
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}
