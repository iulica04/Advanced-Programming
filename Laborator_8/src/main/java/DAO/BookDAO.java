package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.Database;
import Entities.Book;

public class BookDAO {
    public BookDAO() {
    }

    public void create(String title,
                       int id_author,
                       int id_genre,
                       int publication_year,
                       String language,
                       int number_of_pages) {
        // SQL query to insert a new book
        Connection connection = Database.getConnection();
        String query = "INSERT INTO books (title, id_author, id_genre, publication_year, language, number_of_pages) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id_author);
            pstmt.setInt(3, id_genre);
            pstmt.setInt(4, publication_year);
            pstmt.setString(5, language);
            pstmt.setInt(6, number_of_pages);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update(int id,
                       String title,
                       int id_author,
                       int id_genre,
                       int publication_year,
                       String language,
                       int number_of_pages) {
        // SQL query to update a book
        Connection connection = Database.getConnection();
        String query = "UPDATE books SET title = ?, id_author = ?, id_genre = ?, publication_year = ?, language = ?, number_of_pages = ? WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id_author);
            pstmt.setInt(3, id_genre);
            pstmt.setInt(4, publication_year);
            pstmt.setString(5, language);
            pstmt.setInt(6, number_of_pages);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void delete (int id) {
        // SQL query to delete a book
        Connection connection = Database.getConnection();
        String query = "DELETE FROM books WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Book findById(int id) {
        // SQL query to find a book by id
        Connection connection = Database.getConnection();
        String query = "SELECT title, id_author, id_genre, publication_year, language, number_of_pages FROM books WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    int id_author = rs.getInt("id_author");
                    int id_genre = rs.getInt("id_genre");
                    int publication_year = rs.getInt("publication_year");
                    String language = rs.getString("language");
                    int number_of_pages = rs.getInt("number_of_pages");
                    return new Book(id, title, id_author, id_genre, publication_year, language, number_of_pages);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Book findByName(String title) {
        // SQL query to find a book by title
        Connection connection = Database.getConnection();
        String query = "SELECT id, id_author, id_genre, publication_year, language, number_of_pages FROM books WHERE title = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int id_author = rs.getInt("id_author");
                    int id_genre = rs.getInt("id_genre");
                    int publication_year = rs.getInt("publication_year");
                    String language = rs.getString("language");
                    int number_of_pages = rs.getInt("number_of_pages");
                    return new Book(id, title, id_author, id_genre, publication_year, language, number_of_pages);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public void printAll(){
        // SQL query to select all books
        Connection connection = Database.getConnection();
        String query = "SELECT * FROM books";

        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {

                System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Title", "Author", "Genre", "Publication_Year", "Language", "Number_of_Pages");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

                while (rs.next()) {
                    String author = "";
                    String genre = "";

                    int id = rs.getInt("id");
                    String title = rs.getString("title");

                    String anotherQuery1 = "SELECT name FROM authors WHERE id = ?";
                    try(PreparedStatement pstmt2 = connection.prepareStatement(anotherQuery1)) {
                        pstmt2.setInt(1, rs.getInt("id_author"));
                        try(ResultSet rs2 = pstmt2.executeQuery()) {
                            if(rs2.next()) {
                                author = rs2.getString(1);

                            }
                        }
                    }

                    String anotherQuery2 = "SELECT book_genre FROM genre WHERE id = ?";
                    try(PreparedStatement pstmt3 = connection.prepareStatement(anotherQuery2)) {
                        pstmt3.setInt(1, rs.getInt("id_genre"));
                        try(ResultSet rs3 = pstmt3.executeQuery()) {
                            if(rs3.next()) {
                                genre = rs3.getString(1);

                            }
                        }
                    }


                    int publication_year = rs.getInt("publication_year");
                    String language = rs.getString("language");
                    int number_of_pages = rs.getInt("number_of_pages");
                    System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s%n", id, title, author, genre, publication_year, language, number_of_pages);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
