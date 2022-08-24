package com.example.planit.repository;

import com.example.planit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM users WHERE email=:email")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
