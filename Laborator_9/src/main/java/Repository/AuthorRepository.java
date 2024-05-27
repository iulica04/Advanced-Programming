package Repository;

import Entities.Author;
import EntityManager.DatabaseEntity;

import java.util.List;

public class AuthorRepository extends AbstractRepository<Author> {

    public AuthorRepository() {
        super(Author.class);
    }

    @Override
    public void create(Author author) {
        super.create(author);
    }

//    public void create(Author author) {
//        DatabaseEntity.getEntityManager().getTransaction().begin();
//        DatabaseEntity.getEntityManager().persist(author);
//        DatabaseEntity.getEntityManager().getTransaction().commit();
//    }

//    public Author findById(Integer id){
//        return (Author) DatabaseEntity
//                .getEntityManager()
//                .createNamedQuery("Author.findById")
//                .setParameter(1,id)
//                .getSingleResult();
//    }
//
//    public List<Author> findByName(String name){
//        return  DatabaseEntity
//                .getEntityManager()
//                .createQuery("SELECT a FROM Author a WHERE a.name LIKE :name", Author.class)
//                .setParameter("name", "%" + name + "%")
//                .getResultList();
//    }

    @Override
    public Author findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Author> findByName(String name) {
        return super.findByName(name);
    }
}
