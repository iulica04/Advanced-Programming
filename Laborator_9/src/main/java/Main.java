import Entities.Author;
import Entities.Book;
import Entities.PublishingHouse;
import Repository.AuthorRepository;
import Repository.BookRepository;
import Repository.PublishingHouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepository = new AuthorRepository();

        Author author1 = new Author("John Doe");
        authorRepository.create(author1);

        Author author2 = authorRepository.findById(1400);
        System.out.println("Author found by id 1400: " + author2.getName());

        List<Author> authors = authorRepository.findByName("John Leech");
        for (Author author : authors) {
            System.out.println("Author found by name John Leech: " + author.getName());
        }

        System.out.println("\n");

        PublishingHouseRepository publishingHouseRepository = new PublishingHouseRepository();
        PublishingHouse publishingHouse = new PublishingHouse("Example Publishing House");
        publishingHouseRepository.create(publishingHouse);

        BookRepository bookRepository = new BookRepository();


        Book book1 = new Book("The Book of John", authors);
        book1.setPublishingHouse(publishingHouse);
        bookRepository.create(book1);


        Set<Book> booksPublishedByPublishingHouse = publishingHouse.getBooks();
        if (booksPublishedByPublishingHouse != null) {
            for (Book book : booksPublishedByPublishingHouse) {
                System.out.println("Book published by " + publishingHouse.getName() + ": " + book.getTitle());
            }
        } else {
            System.out.println("No books published by " + publishingHouse.getName());
        }
    }

}
