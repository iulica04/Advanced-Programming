package Entities;

import java.util.Date;

public class Book {
    int id;
    String title;
    String publisherDate;
    String language;
    int numberOfPages;
    double averageRating;
    String isbn;
    String isbn13;
    String publisher;
    int ratingCount;
    int textReviewsCount;


    public Book(int id,
                String title,
                String publisherDate,
                String language,
                int numberOfPages,
                double averageRating,
                String isbn,
                String isbn13,
                String publisher,
                int ratingCount,
                int textReviewsCount) {
        this.id = id;
        this.title = title;
        this.publisherDate = publisherDate;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.averageRating = averageRating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.ratingCount = ratingCount;
        this.textReviewsCount = textReviewsCount;

    }

    Book() {
    }

    public String getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(String publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getTextReviewsCount() {
        return textReviewsCount;
    }

    public void setTextReviewsCount(int textReviewsCount) {
        this.textReviewsCount = textReviewsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
