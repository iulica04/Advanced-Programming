package com.example.laborator_11.repository;

import com.example.laborator_11.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
