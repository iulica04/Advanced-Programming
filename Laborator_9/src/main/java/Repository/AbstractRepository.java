package Repository;

import jakarta.persistence.EntityManager;

import java.util.List;

import EntityManager.DatabaseEntity;

public abstract class AbstractRepository<T> {
    private Class<T> entityClass;

    protected AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager em = DatabaseEntity.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public T findById(Integer id) {
        EntityManager em = DatabaseEntity.getEntityManager();
        return em.find(entityClass, id);
    }

    public List<T> findByName(String name) {
        EntityManager em = DatabaseEntity.getEntityManager();
        String query = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.name LIKE :name";
        return em.createQuery(query, entityClass)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
