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
        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();
        String query = "SELECT * FROM bookauthors";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.printf("%-10s %-10s %-10s%n", "ID", "Book", "Author");
            System.out.println("------------------------------------");

            while (rs.next()) {
                int bookAuthorId = rs.getInt("id");
                String book = bookDAO.findById(rs.getInt("book_id")).getTitle();
                String author = authorDAO.findById(rs.getInt("author_id")).getName();
                System.out.printf("%-10s %-10s %-10s%n", bookAuthorId, book, author);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
