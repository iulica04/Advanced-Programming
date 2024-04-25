package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection; // Schimbat de la Database
import Entities.Book;

public class BookDAO {
    public BookDAO() {
    }

    public void create(String title,
                       int id_author,
                       int id_genre,
                       Date publisher_date,
                       String language,
                       int number_of_pages,
                       double average_rating,
                       int isbn,
                       int isbn13,
                       String publisher,
                       int rating_count,
                       int text_reviews_count) throws SQLException {
        // SQL query to insert a new book
        String query = "INSERT INTO books (title, id_author, id_genre, publisher_date, language, number_of_pages, average_rating, isbn, isbn13, publisher, rating_count, text_reviews_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id_author);
            pstmt.setInt(3, id_genre);
            pstmt.setDate(4, publisher_date);
            pstmt.setString(5, language);
            pstmt.setInt(6, number_of_pages);
            pstmt.setDouble(7, average_rating);
            pstmt.setInt(8, isbn);
            pstmt.setInt(9, isbn13);
            pstmt.setString(10, publisher);
            pstmt.setInt(11, rating_count);
            pstmt.setInt(12, text_reviews_count);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(int id,
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
                       int text_reviews_count) throws SQLException {
        // SQL query to update a book
        String query = "UPDATE books SET title = ?, id_author = ?, id_genre = ?, publisher_date = ?, language, number_of_pages = ?, average_rating = ?, isbn = ?, isbn13 = ?, publisher, rating_count = ?, text_reviews_count = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id_author);
            pstmt.setInt(3, id_genre);
            pstmt.setString(4, publisher_date);
            pstmt.setString(5, language);
            pstmt.setInt(6, number_of_pages);
            pstmt.setDouble(7, average_rating);
            pstmt.setInt(8, isbn);
            pstmt.setInt(9, isbn13);
            pstmt.setString(10, publisher);
            pstmt.setInt(11, rating_count);
            pstmt.setInt(12, text_reviews_count);
            pstmt.setInt(13, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delete(int id) throws SQLException {
        // SQL query to delete a book
        String query = "DELETE FROM books WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Book findById(int id) throws SQLException {
        // SQL query to find a book by id
        String query = "SELECT * FROM books WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    int id_author = rs.getInt("id_author");
                    int id_genre = rs.getInt("id_genre");
                    String publisher_date = rs.getString("publisher_date");
                    String language = rs.getString("language");
                    int number_of_pages = rs.getInt("number_of_pages");
                    double average_rating = rs.getDouble("average_rating");
                    int isbn = rs.getInt("isbn");
                    int isbn13 = rs.getInt("isbn13");
                    String publisher = rs.getString("publisher");
                    int rating_count = rs.getInt("rating_count");
                    int text_reviews_count = rs.getInt("text_reviews_count");

                    return new Book(id, title, id_author, id_genre, publisher_date, language, number_of_pages, average_rating, isbn, isbn13, publisher, rating_count, text_reviews_count);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public Book findByName(String title) throws SQLException {
        // SQL query to find a book by title
        String query = "SELECT * FROM books WHERE title = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int id_author = rs.getInt("id_author");
                    int id_genre = rs.getInt("id_genre");
                    String publisher_date = rs.getString("publisher_date");
                    String language = rs.getString("language");
                    int number_of_pages = rs.getInt("number_of_pages");
                    double average_rating = rs.getInt("average_rating");
                    int isbn = rs.getInt("isbn");
                    int isbn13 = rs.getInt("isbn13");
                    String publisher = rs.getString("publisher");
                    int rating_count = rs.getInt("rating_count");
                    int text_reviews_count = rs.getInt("text_reviews_count");

                    return new Book(id, title, id_author, id_genre, publisher_date, language, number_of_pages, average_rating, isbn, isbn13, publisher, rating_count, text_reviews_count);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public void printAll() {
        // SQL query to select all books
        String query = "SELECT * FROM books";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                    "ID", "Title", "Author", "Genre", "Publication_Year", "Language", "Number_of_Pages", "Publisher", "Average_Rating", "ISBN", "ISBN13", "Rating_Count", "Text_Reviews_Count");

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = findAuthorName(connection, rs.getInt("id_author"));
                String genre = findGenreName(connection, rs.getInt("id_genre"));
                String publisher_date = rs.getString("publisher_date");
                String language = rs.getString("language");
                int number_of_pages = rs.getInt("number_of_pages");
                String publisher = rs.getString("publisher");
                double average_rating = rs.getDouble("average_rating");
                int isbn = rs.getInt("isbn");
                int isbn13 = rs.getInt("isbn13");
                int rating_count = rs.getInt("rating_count");
                int text_reviews_count = rs.getInt("text_reviews_count");

                System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                        id, title, author, genre, publisher_date, language, number_of_pages, publisher, average_rating, isbn, isbn13, rating_count, text_reviews_count);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private String findAuthorName(Connection connection, int id_author) throws SQLException {
        // SQL query to get author name by ID
        String query = "SELECT name FROM authors WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id_author);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        }

        return "Unknown";
    }


    private String findGenreName(Connection connection, int id_genre) throws SQLException {
        // SQL query to get genre name by ID

        String query = "SELECT book_genre FROM genre WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id_genre);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("book_genre");
                }
            }
        }

        return "Unknown";
    }
}