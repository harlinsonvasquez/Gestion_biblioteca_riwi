package com.example.Gestion_biblioteca_riwi.domain.repositories;

import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
