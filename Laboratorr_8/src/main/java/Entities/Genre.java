package Entities;

public class Genre {
    int id;
    String bookGenre;

    public Genre(int id, String bookGenre) {
        this.id = id;
        this.bookGenre = bookGenre;
    }

    Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String book_genre) {
        this.bookGenre = book_genre;
    }
}
