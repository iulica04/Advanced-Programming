import DAO.AuthorDAO;
import DAO.BookAuthorsDAO;
import DAO.GenreDAO;
import DAO.BookDAO;

import Entities.Genre;
import Entities.Author;
import Entities.Book;

import Database.Database;
import Database.DataImporterFromCSV;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
         //   DataImporterFromCSV.importCSVAuthors("D:\\Advanced-Programming\\Laboratorr_8\\src\\main\\resources\\books.csv");
            DataImporterFromCSV.importCSVBooks("D:\\Advanced-Programming\\Laboratorr_8\\src\\main\\resources\\books.csv");

            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.printAll();

            BookDAO bookDAO = new BookDAO();
            bookDAO.printAll();

            BookAuthorsDAO bookAuthorsDAO = new BookAuthorsDAO();
            bookAuthorsDAO.printAll();

            Database.getConnection().commit();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            Database.closeConnection();
        }
    }
}