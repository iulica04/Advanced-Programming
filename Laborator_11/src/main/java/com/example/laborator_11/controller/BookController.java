package com.example.laborator_11.controller;


import com.example.laborator_11.dto.BookDTO;
import com.example.laborator_11.dto.BookInputDTO;
import com.example.laborator_11.entity.Author;
import com.example.laborator_11.entity.Book;
import com.example.laborator_11.repository.AuthorRepository;
import com.example.laborator_11.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getPublisher_date(),
                book.getLanguage(),
                book.getNumber_of_pages(),
                book.getAverage_rating(),
                book.getIsbn(),
                book.getIsbn13(),
                book.getRating_count(),
                book.getText_reviews_count(),
                book.getAuthors()
        )).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public Book addBook(@RequestBody BookInputDTO bookInputDTO) {
        // Create a new Book entity
        Book book = new Book();
        book.setTitle(bookInputDTO.getTitle());
        book.setPublisher_date(bookInputDTO.getPublisher_date());
        book.setLanguage(bookInputDTO.getLanguage());
        book.setNumber_of_pages(bookInputDTO.getNumber_of_pages());
        book.setAverage_rating(bookInputDTO.getAverage_rating());
        book.setIsbn(bookInputDTO.getIsbn());
        book.setIsbn13(bookInputDTO.getIsbn13());
        book.setRating_count(bookInputDTO.getRating_count());
        book.setText_reviews_count(bookInputDTO.getText_reviews_count());

        Set<Author> authors = new HashSet<>();
        for (String authorName : bookInputDTO.getAuthors()) {
            Optional<Author> optionalAuthor = authorRepository.findByName(authorName);
            Author author;
            if (optionalAuthor.isPresent()) {
                author = optionalAuthor.get();
            } else {
                author = new Author();
                author.setName(authorName);
                author = authorRepository.save(author);
            }
            authors.add(author);
        }
        book.setAuthors(authors);

        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookName(@PathVariable("id") long id, @RequestBody String newName) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(newName);
            bookRepository.save(book);
            return ResponseEntity.ok().body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
