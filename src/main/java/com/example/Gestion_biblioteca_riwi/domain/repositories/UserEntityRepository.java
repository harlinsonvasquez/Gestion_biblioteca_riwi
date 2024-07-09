package com.example.Gestion_biblioteca_riwi.domain.repositories;

import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @EntityGraph(attributePaths = {"reservationList", "loanList"})
    Optional<UserEntity> findById(Long id);
}
