package EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EntityManagerFactorySingleton {
    private static EntityManagerFactory instance;

    public static synchronized EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("BooksStorePU");
        }
        return instance;
    }

    public static void close() {
        if (instance != null && instance.isOpen()) {
            instance.close();
        }
    }
}
