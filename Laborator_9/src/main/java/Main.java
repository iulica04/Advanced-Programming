import Entities.Author;
import Repository.AuthorRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepository = new AuthorRepository();

        Author author1 = new Author("John Doe");
        authorRepository.create(author1);

        Author author2 = authorRepository.findById(1465);
        System.out.println("Author found by id 1465: " + author2.getName());

        List<Author> authors = authorRepository.findByName("John Leech");
        for(Author author : authors){
            System.out.println("Author found by name John Leech: " + author.getName());
        }

        System.out.println("\n");




    }

}
