package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Database.Database;
import Entities.Genre;

public class GenreDAO {

    public GenreDAO() {
    }

    public void create(String book_genre) {
        // SQL query to insert a new genre
        Connection connection = Database.getConnection();
        String query = "INSERT INTO genre (book_genre) VALUES (?)";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book_genre);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update(int id, String book_genre) {
        // SQL query to update a genre
        Connection connection = Database.getConnection();
        String query = "UPDATE genre SET book_genre = ? WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, book_genre);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void delete(int id) {
        // SQL query to delete a genre
        Connection connection = Database.getConnection();
        String query = "DELETE FROM genre WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Genre findByName(String book_genre) {
        // SQL query to find a genre by name
        Connection con = Database.getConnection();
        String query = "SELECT id, book_genre FROM genre WHERE book_genre = ?";

        try(PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, book_genre);

            try(var rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    return new Genre(rs.getInt(1), rs.getString(2));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public Genre findById(int id) {
        // SQL query to find a genre by id
        Connection con = Database.getConnection();
        String query = "SELECT id, book_genre FROM genre WHERE id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try(var rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    return new Genre(rs.getInt(1), rs.getString(2));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public void printAll() {
        // SQL query to select all genres
        Connection connection = Database.getConnection();
        String query = "SELECT * FROM genre";

        try(PreparedStatement pstmt = connection.prepareStatement(query);
            var rs = pstmt.executeQuery()) {

            System.out.printf("%-10s %-20s%n", "ID", "Book_genre");
            System.out.println("---------------------------------");

            while(rs.next()) {
                int id = rs.getInt(1);
                String book_genre = rs.getString(2);
                System.out.printf("%-10s %-20s%n", id, book_genre);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
