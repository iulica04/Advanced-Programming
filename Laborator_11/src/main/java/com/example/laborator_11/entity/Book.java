package com.example.laborator_11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "bookauthors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @Column(name = "publisher_date")
    private String publisher_date;

    @Column(name = "language")
    private String language;

    @Column(name = "number_of_pages")
    private int number_of_pages;

    @Column(name = "average_rating")
    private double average_rating;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "isbn13")
    private String isbn13;

    @Column(name = "rating_count")
    private int rating_count;

    @Column(name = "text_reviews_count")
    private int text_reviews_count;

}
