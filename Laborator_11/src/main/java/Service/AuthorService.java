package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DAO.AuthorDAO;
import Entities.Author;

import java.sql.SQLException;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorDAO authorDao;

    @Autowired
    public AuthorService(AuthorDAO authorDao) {
        this.authorDao = authorDao;
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorDao.getAllAuthors();
    }
}
