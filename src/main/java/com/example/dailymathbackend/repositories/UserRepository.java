package com.example.dailymathbackend.repositories;

import com.example.dailymathbackend.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByUserEmail(String userEmail);
    Optional<UserEntity> findByUserLogin(String userLogin);
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserLogin(String userLogin);
}
