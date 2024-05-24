package com.example.laborator_11.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookInputDTO {
    private String title;
    private String publisher_date;
    private String language;
    private int number_of_pages;
    private double average_rating;
    private String isbn;
    private String isbn13;
    private int rating_count;
    private int text_reviews_count;
    private List<String> authors;

    public BookInputDTO(String title, String publisher_date, String language, int number_of_pages, double average_rating, String isbn, String isbn13, int rating_count, int text_reviews_count, List<String> authorNames) {
        this.title = title;
        this.publisher_date = publisher_date;
        this.language = language;
        this.number_of_pages = number_of_pages;
        this.average_rating = average_rating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.rating_count = rating_count;
        this.text_reviews_count = text_reviews_count;
        this.authors = authorNames;
    }

}
