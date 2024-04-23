package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.Database;
import Entities.Author;
public class AuthorDAO {
    public AuthorDAO() {
    }

    public void create(String name) throws SQLException {
        // SQL query to insert a new author
        Connection connection = Database.getConnection();
        String query = "INSERT INTO authors (name) VALUES (?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update(int id, String name) throws SQLException {
        // SQL query to update an author
        Connection connection = Database.getConnection();
        String query = "UPDATE authors SET name = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public void delete(int id) throws SQLException {
        // SQL query to delete an author
        Connection connection = Database.getConnection();
        String query = "DELETE FROM authors WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public Author findByName(String name) throws SQLException {
        // SQL query to find an author by name
        Connection con = Database.getConnection();
        String query = "SELECT id, name FROM authors WHERE name = ?"; // Selectează atât ID-ul, cât și numele

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int authorId = rs.getInt("id");
                    return new Author(authorId, name);
                } else {
                    return null;
                }
            }
        }
    }

    public Author findById(int id) throws SQLException {
        // SQL query to find an author by id
        Connection con = Database.getConnection();
        String query = "SELECT id, name FROM authors WHERE id = ?"; // Selectează atât ID-ul, cât și numele

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String authorName = rs.getString("name");
                    return new Author(id, authorName);
                } else {
                    return null;
                }
            }
        }
    }


    public void printAll () throws SQLException {
        // SQL query to print all authors
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM authors")) {
            pstmt.execute();

            System.out.printf("%-10s %-20s%n", "ID", "Name");
            System.out.println("----------------------------");

            while (pstmt.getResultSet().next()) {
                System.out.printf("%-10s %-20s%n", pstmt.getResultSet().getString(1), pstmt.getResultSet().getString(2));
            }
        }
    }

}
