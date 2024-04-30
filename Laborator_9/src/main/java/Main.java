import Entities.Author;
import EntityManager.EntityManagerFactorySingleton;
import Repository.AuthorRepository;

public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepo = new AuthorRepository();

        // Create new author
        Author author = new Author("Ion Creanga");
        authorRepo.create(author);


        authorRepo.close();
        EntityManagerFactorySingleton.close();  // Close EMF to avoid resource leaks
    }
}
