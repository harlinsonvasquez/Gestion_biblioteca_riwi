package com.example.Gestion_biblioteca_riwi.domain.repositories;

import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}