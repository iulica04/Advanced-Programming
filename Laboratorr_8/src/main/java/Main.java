import DAO.AuthorDAO;
import DAO.BookAuthorsDAO;
import DAO.GenreDAO;
import DAO.BookDAO;

import Entities.Genre;
import Entities.Author;
import Entities.Book;

import Database.DatabaseConnection;
import Database.DataImporterFromCSV;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            DataImporterFromCSV.importCSVAuthors("D:\\Advanced-Programming\\Laboratorr_8\\src\\main\\resources\\books.csv");
            DataImporterFromCSV.importCSVBooks("D:\\Advanced-Programming\\Laboratorr_8\\src\\main\\resources\\books.csv");

            GenreDAO genreDAO = new GenreDAO();
            genreDAO.printAll();  // l-am folosit deoarece am cititi slide-urile (unde era specificat), apoi am vazut ca in csv nu exista coloana genre

            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.printAll();

            BookDAO bookDAO = new BookDAO();
            bookDAO.printAll();


        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}