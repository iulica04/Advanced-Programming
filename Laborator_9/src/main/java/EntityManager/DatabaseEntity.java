package EntityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;

public class DatabaseEntity {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    private DatabaseEntity () {

    }

    public static EntityManager getEntityManager() {
        if(entityManager == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("BooksStorePU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
