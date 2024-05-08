package Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import EntityManager.DatabaseEntity;

import java.util.List;

public abstract class AbstractRepository<T>{
    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        DatabaseEntity.getEntityManager().getTransaction().begin();
        DatabaseEntity.getEntityManager().persist(entity);
        DatabaseEntity.getEntityManager().getTransaction().commit();
    }
    public T findById(Integer id) {
        return (T) DatabaseEntity
                .getEntityManager()
                .createNamedQuery(entityClass.getSimpleName() + ".findById")
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<T> findByName(String name) {
        return DatabaseEntity
                .getEntityManager()
                .createNamedQuery(entityClass.getSimpleName() + ".findByName")
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
