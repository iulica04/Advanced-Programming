import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            AuthorDAO authorDAO = new AuthorDAO();
//            authorDAO.create("Liviu Rebreanu");
//            authorDAO.create("Ion Creanga");
//            authorDAO.create("Collen Hoover");

            authorDAO.printAll();
            System.out.println("Author: Collen Hoover --> Id: " + authorDAO.findByName("Collen Hoover"));
            System.out.println("Id: 2 --> Author: " + authorDAO.findById(2));
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            Database.closeConnection();
        }
    }
}
