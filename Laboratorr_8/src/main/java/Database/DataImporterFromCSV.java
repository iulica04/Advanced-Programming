package Database;

import DAO.AuthorDAO;
import DAO.BookDAO;
import DAO.BookAuthorsDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataImporterFromCSV {
    public static void importCSVAuthors(String path) {
        AuthorDAO authorDAO = new AuthorDAO();
        try(
            BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");

                String[] names = data[2].split("/");
                for (String name : names) {
                    name = name.trim(); //
                    if (!name.isEmpty() && authorDAO.findByName(name) == null){
                        authorDAO.create(name);
                    }
                }
            }

        } catch ( IOException  | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void importCSVBooks(String path) {
        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();
        BookAuthorsDAO bookAuthorDAO = new BookAuthorsDAO();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if(data.length != 12)     // sunt linii care nu respecta structura
                {
                    continue;
                }
                String title = data[1];
                index++;

                String date = data[10];
                System.out.println(index + " Date: " + date);
                String[] componentsOfData = date.split("/"); // luna/zi/year in CSV ----- year-luna-zi in SQL

                try{
                    bookDAO.create(data[1],
                            Date.valueOf(LocalDate.of(Integer.parseInt(componentsOfData[2]), Integer.parseInt(componentsOfData[1]), Integer.parseInt(componentsOfData[0]))),
                            data[6],
                            Integer.parseInt(data[7]),
                            Double.parseDouble(data[3]),
                            data[4],
                            data[5],
                            data[11],
                            Integer.parseInt(data[8]),
                            Integer.parseInt(data[9]));
                } catch (Exception e) {
                    System.out.println("Invalid data " + date);
                    continue;
                }


                if(bookDAO.findByName(title) != null){
                    int bookId = bookDAO.findByName(title).getId();

                    String[] names = data[2].split("/");
                    for (String name : names) {
                        name = name.trim();
                        int authorId = authorDAO.findByName(name).getId();
                        bookAuthorDAO.create(bookId, authorId);
                    }
                }
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
