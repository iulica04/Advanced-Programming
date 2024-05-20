package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;
import Entities.Book;

public class BookDAO {
    public BookDAO() {
    }

    public void create(String title,
                       Date publisherDate,
                       String language,
                       int numberOfPages,
                       double averageRating,
                       String isbn,
                       String isbn13,
                       String publisher,
                       int ratingCount,
                       int textReviewsCount) throws SQLException {
        // SQL query to insert a new book
        String query = "INSERT INTO books (title, publisher_date, language, number_of_pages, average_rating, isbn, isbn13, publisher, rating_count, text_reviews_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setDate(2, publisherDate);
            pstmt.setString(3, language);
            pstmt.setInt(4, numberOfPages);
            pstmt.setDouble(5, averageRating);
            pstmt.setString(6, isbn);
            pstmt.setString(7, isbn13);
            pstmt.setString(8, publisher);
            pstmt.setInt(9, ratingCount);
            pstmt.setInt(10, textReviewsCount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(int id,
                       String title,
                       Date publisherDate,
                       String language,
                       int numberOfPages,
                       double averageRating,
                       String isbn,
                       String isbn13,
                       String publisher,
                       int ratingCount,
                       int textReviewsCount) throws SQLException {
        // SQL query to update a book
        String query = "UPDATE books SET title = ?, publisher_date = ?, language = ?, number_of_pages = ?, average_rating = ?, isbn = ?, isbn13 = ?, publisher = ?, rating_count = ?, text_reviews_count = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setDate(2, publisherDate);
            pstmt.setString(3, language);
            pstmt.setInt(4, numberOfPages);
            pstmt.setDouble(5, averageRating);
            pstmt.setString(6, isbn);
            pstmt.setString(7, isbn13);
            pstmt.setString(8, publisher);
            pstmt.setInt(9, ratingCount);
            pstmt.setInt(10, textReviewsCount);
            pstmt.setInt(11, id);
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
                    String publisherDate = rs.getString("publisher_date");
                    String language = rs.getString("language");
                    int numberOfPages = rs.getInt("number_of_pages");
                    double averageRating = rs.getDouble("average_rating");
                    String isbn = rs.getString("isbn");
                    String isbn13 = rs.getString("isbn13");
                    String publisher = rs.getString("publisher");
                    int ratingCount = rs.getInt("rating_count");
                    int textReviewsCount = rs.getInt("text_reviews_count");

                    return new Book(id, title, publisherDate, language, numberOfPages, averageRating, isbn, isbn13, publisher, ratingCount, textReviewsCount);
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
                    String publisherDate = rs.getString("publisher_date");
                    String language = rs.getString("language");
                    int numberOfPages = rs.getInt("number_of_pages");
                    double averageRating = rs.getDouble("average_rating");
                    String isbn = rs.getString("isbn");
                    String isbn13 = rs.getString("isbn13");
                    String publisher = rs.getString("publisher");
                    int ratingCount = rs.getInt("rating_count");
                    int textReviewsCount = rs.getInt("text_reviews_count");

                    return new Book(id, title, publisherDate, language, numberOfPages, averageRating, isbn, isbn13, publisher, ratingCount, textReviewsCount);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public void printAll() throws SQLException {
        // SQL query to select all books
        BookAuthorsDAO bookAuthorsDAO = new BookAuthorsDAO();
        String query = "SELECT * FROM books";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Books: ");

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date publisherDate = rs.getDate("publisher_date");
                String language = rs.getString("language");
                int numberOfPages = rs.getInt("number_of_pages");
                String publisher = rs.getString("publisher");
                double averageRating = rs.getDouble("average_rating");
                String isbn = rs.getString("isbn");
                String isbn13 = rs.getString("isbn13");
                int ratingCount = rs.getInt("rating_count");
                int textReviewsCount = rs.getInt("text_reviews_count");

                System.out.println("\n\n Book with id: " + id);
                System.out.println("   --> Title: " + title);
                bookAuthorsDAO.findAuthors(title);
                System.out.println("   --> Publisher Date: " + publisherDate);
                System.out.println("   --> Language: " + language);
                System.out.println("   --> Number of Pages: " + numberOfPages);
                System.out.println("   --> Publisher: " + publisher);
                System.out.println("   --> Average Rating: " + averageRating);
                System.out.println("   --> ISBN: " + isbn);
                System.out.println("   --> ISBN13: " + isbn13);
                System.out.println("   --> Rating Count: " + ratingCount);
                System.out.println("   --> Text Reviews Count: " + textReviewsCount);

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
