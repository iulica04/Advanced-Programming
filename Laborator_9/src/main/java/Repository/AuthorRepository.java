package Repository;

import Entities.Author;
import EntityManager.EntityManagerFactorySingleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public class AuthorRepository {
    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

    public void create(Author author) {
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    public List<Author> findByName(String namePattern) {
        TypedQuery<Author> query = em.createNamedQuery("Author.findByName", Author.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
