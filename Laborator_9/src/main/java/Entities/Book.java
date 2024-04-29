package Entities;
import javax.persistence.*;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

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

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "rating_count")
    private int rating_count;

    @Column(name = "text_reviews_count")
    private int text_reviews_count;

    public Book(int id,
                String title,
                String publisher_date,
                String language,
                int number_of_pages,
                double average_rating,
                String isbn,
                String isbn13,
                String publisher,
                int rating_count,
                int text_reviews_count) {
        this.id = id;
        this.title = title;
        this.publisher_date = publisher_date;
        this.language = language;
        this.number_of_pages = number_of_pages;
        this.average_rating = average_rating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.rating_count = rating_count;
        this.text_reviews_count = text_reviews_count;
    }

    Book() {
    }

    public String getPublisher_date() {
        return publisher_date;
    }

    public void setPublisher_date(String publisher_date) {
        this.publisher_date = publisher_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
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

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public int getText_reviews_count() {
        return text_reviews_count;
    }

    public void setText_reviews_count(int text_reviews_count) {
        this.text_reviews_count = text_reviews_count;
    }

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher_date='" + publisher_date + '\'' +
                ", language='" + language + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", average_rating=" + average_rating +
                ", isbn=" + isbn +
                ", isbn13=" + isbn13 +
                ", publisher='" + publisher + '\'' +
                ", rating_count=" + rating_count +
                ", text_reviews_count=" + text_reviews_count +
                '}';
    }

}
