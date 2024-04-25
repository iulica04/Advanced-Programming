package Entities;

public class Book {
    int id;
    String title;
    int id_author;
    int id_genre;
    String publisher_date;
    String language;
    int number_of_pages;
    double average_rating;
    int isbn;
    int isbn13;
    String publisher;
    int rating_count;
    int text_reviews_count;


    public Book(int id,
                String title,
                int id_author,
                int id_genre,
                String publisher_date,
                String language,
                int number_of_pages,
                double average_rating,
                int isbn,
                int isbn13,
                String publisher,
                int rating_count,
                int text_reviews_count){
        this.id = id;
        this.title = title;
        this.id_author = id_author;
        this.id_genre = id_genre;
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

    Book() {}

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

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(int isbn13) {
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
                ", id_author=" + id_author +
                ", id_genre=" + id_genre +
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
