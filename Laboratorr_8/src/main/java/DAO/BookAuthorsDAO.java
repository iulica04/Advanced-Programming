package DAO;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAuthorsDAO {
    public void create(int bookId, int authorId) throws SQLException {
        String query = "INSERT INTO bookauthors (book_id, author_id) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, authorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(int bookAuthorId, int bookId, int authorId) throws SQLException {
        String query = "UPDATE bookauthors SET book_id = ?, author_id = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, authorId);
            pstmt.setInt(3, bookAuthorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }


    public void delete(int bookAuthorId) throws SQLException {
        String query = "DELETE FROM bookauthors WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bookAuthorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void printAll() throws SQLException {
        String query = "SELECT b.title AS book_title, STRING_AGG(a.name, ', ') AS author_names "
                + "FROM BookAuthors ba "
                + "JOIN Books b ON ba.book_id = b.id "
                + "JOIN Authors a ON ba.author_id = a.id "
                + "GROUP BY b.title;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.printf("%-100s %-50s%n", "Book Title", "Authors");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                String bookTitle = rs.getString("book_title");
                String authorNames = rs.getString("author_names");

                System.out.printf("%-100s %-50s%n", bookTitle, authorNames);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public boolean combinationExists(int bookId, int authorId) {
        String query = "SELECT EXISTS(SELECT 1 FROM bookauthors WHERE book_id = ? AND author_id = ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, authorId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;
    }

    public void findAuthors(String bookTitle) {
        String query = "SELECT a.name AS author_name "
                + "FROM BookAuthors ba "
                + "JOIN Books b ON ba.book_id = b.id "
                + "JOIN Authors a ON ba.author_id = a.id "
                + "WHERE b.title = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bookTitle);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("   --> Authors: ");

                while (rs.next()) {
                    String authorName = rs.getString("author_name");

                    System.out.println("   ----> " + authorName);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void findBooksWrittenByAuthor(String authorName) {
        String query = "SELECT b.title AS book_title "
                + "FROM BookAuthors ba "
                + "JOIN Books b ON ba.book_id = b.id "
                + "JOIN Authors a ON ba.author_id = a.id "
                + "WHERE a.name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, authorName);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Books written by the author \"" + authorName + "\":");

                while (rs.next()) {
                    String bookTitle = rs.getString("book_title");

                    System.out.println("   -> " + bookTitle);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
