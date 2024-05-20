package com.example.Laborator_11.Repository;

import com.example.Laborator_11.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
