import Entities.Author;
import EntityManager.EntityManagerFactorySingleton;
import Repository.AuthorRepository;

public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepo = new AuthorRepository();

        // Create new author
        Author author = new Author("Ion Creanga");
        authorRepo.create(author);

        // Find author by ID
//        Author foundAuthor = authorRepo.findById(author.getId());
//        System.out.println("Found author: " + foundAuthor);
//
//        // Find authors by name pattern
//        var authors = authorRepo.findByName("John");
//        System.out.println("Authors with 'John':");
//        authors.forEach(System.out::println);

        authorRepo.close();
        EntityManagerFactorySingleton.close();  // Close EMF to avoid resource leaks
    }
}
