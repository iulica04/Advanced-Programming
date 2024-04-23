package Entities;

public class Book {
    int id;
    String title;
    int id_author;
    int id_genre;
    int publication_year;
    String language;
    int number_of_pages;

    public Book(int id, String title, int id_author, int id_genre, int publication_year, String language, int number_of_pages) {
        this.id = id;
        this.title = title;
        this.id_author = id_author;
        this.id_genre = id_genre;
        this.publication_year = publication_year;
        this.language = language;
        this.number_of_pages = number_of_pages;
    }

    Book() {}

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
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
}
