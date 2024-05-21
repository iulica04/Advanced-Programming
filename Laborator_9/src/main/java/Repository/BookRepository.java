package Repository;

import Entities.Book;

import java.util.List;


public class BookRepository extends AbstractRepository<Book> {

    public BookRepository() {
        super(Book.class);
    }

    @Override
    public void create(Book book) {
        super.create(book);
    }

    @Override
    public Book findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return super.findByName(name);
    }


}

