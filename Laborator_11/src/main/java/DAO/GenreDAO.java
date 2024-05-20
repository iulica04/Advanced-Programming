package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.DatabaseConnection;
import Entities.Genre;

public class GenreDAO {

    public GenreDAO() {
    }

    public void create(String bookGenre) {
        // SQL query to insert a new genre
        String query = "INSERT INTO genre (book_genre) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bookGenre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(int id, String bookGenre) throws SQLException {
        // SQL query to update a genre
        String query = "UPDATE genre SET book_genre = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bookGenre);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM genre WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Genre findByName(String bookGenre) {
        String query = "SELECT id, book_genre FROM genre WHERE book_genre = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bookGenre);

            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Genre(rs.getInt(1), rs.getString(2));
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Genre findById(int id) {
        String query = "SELECT id, book_genre FROM genre WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Genre(rs.getInt(1), rs.getString(2));
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public void printAll() throws SQLException {
        String query = "SELECT * FROM genre";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             var rs = pstmt.executeQuery()) {

            System.out.println("Genres: ");

            while (rs.next()) {
                int id = rs.getInt(1);
                String book_genre = rs.getString(2);
                System.out.println("  --> Id: " + id + ", Genre: " + book_genre);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
