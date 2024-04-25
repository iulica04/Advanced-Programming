package Entities;

public class Genre {
    int id;
    String book_genre;

    public Genre(int id, String book_genre) {
        this.id = id;
        this.book_genre = book_genre;
    }

    Genre() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }
}
