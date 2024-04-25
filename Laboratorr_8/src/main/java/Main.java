import DAO.AuthorDAO;
import DAO.GenreDAO;
import DAO.BookDAO;

import Entities.Genre;
import Entities.Author;
import Entities.Book;

import Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            AuthorDAO authorDAO = new AuthorDAO();
          /*  authorDAO.create("Liviu Rebreanu");
            authorDAO.create("Ion Creanga");
            authorDAO.create("Collen Hoover");
            authorDAO.create("Leo Tolstoy");
            authorDAO.create("Fyodor Dostoevsky");
            authorDAO.create("Jane Austen");
            authorDAO.create("George Orwell"); */

            authorDAO.printAll();
            System.out.print("\n\n");

            GenreDAO genreDAO = new GenreDAO();
           /* genreDAO.create("Horror");
            genreDAO.create("Romance");
            genreDAO.create("Science Fiction");
            genreDAO.create("Fantasy");
            genreDAO.create("Mystery");
            genreDAO.create("Thriller");
            genreDAO.create("Historical Fiction");
            genreDAO.create("Biography");
            genreDAO.create("Autobiography");
            genreDAO.create("Self-Help");
            genreDAO.create("Comedy");
            genreDAO.create("Drama");
            genreDAO.create("Adventure");
            genreDAO.create("Action");
            genreDAO.create("Crime");
            genreDAO.create("Poetry");
            genreDAO.create("Children's"); */


            BookDAO bookDAO = new BookDAO();
           /* bookDAO.create("It Ends With Us", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2016, "English", 384);
            bookDAO.create("Verity", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Thriller").getId(), 2018, "English", 333);
            bookDAO.create("November 9", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2015, "English", 320);
            bookDAO.create("Ugly Love", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2014, "English", 322);
            bookDAO.create("Hopeless", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2012, "English", 410);
            bookDAO.create("Slammed", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2012, "English", 317);
            bookDAO.create("Point of Retreat", authorDAO.findByName("Collen Hoover").getId(), genreDAO.findByName("Romance").getId(), 2012, "English", 320); */

            genreDAO.printAll();
            System.out.print("\n\n");

            bookDAO.printAll();
            System.out.print("\n\n");

            System.out.println("Author: Collen Hoover --> Id: " + authorDAO.findByName("Collen Hoover").getId());
            System.out.println("Id: 2 --> Author: " + authorDAO.findById(2).getName());
            System.out.print("\n\n");

            System.out.println("Genre: Horror --> Id: " + genreDAO.findByName("Horror").getId());
            System.out.println("Id: 2 --> Genre: " + genreDAO.findById(2).getBook_genre());
            Database.getConnection().commit();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            Database.closeConnection();
        }
    }
}