package DAO;

import java.sql.*;

import Database.DatabaseConnection;
import Entities.Author;

public class AuthorDAO {
    public AuthorDAO() {
    }

    public  void create(String name) throws SQLException {
        // SQL query to insert a new author
        String query = "INSERT INTO authors (name) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(int id, String name) throws SQLException {
        // SQL query to update an author
        String query = "UPDATE authors SET name = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delete(int id) throws SQLException {
        // SQL query to delete an author
        String query = "DELETE FROM authors WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Author findByName(String name) throws SQLException {
        // SQL query to find an author by name
        String query = "SELECT id, name FROM authors WHERE name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int authorId = rs.getInt("id");
                    return new Author(authorId, name);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public Author findById(int id) throws SQLException {
        // SQL query to find an author by id
        String query = "SELECT id, name FROM authors WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String authorName = rs.getString("name");
                    return new Author(id, authorName);
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
        // SQL query to print all authors
        String query = "SELECT * FROM authors";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Authors: ");

            while (rs.next()) {
                System.out.println("  --> Id: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}