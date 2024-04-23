import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        String query = "SELECT id FROM authors WHERE name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public String findById(int id) throws SQLException {
        // SQL query to find an author by id
        Connection connection = Database.getConnection();
        String query = "SELECT name FROM authors WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
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
