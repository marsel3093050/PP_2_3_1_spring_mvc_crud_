package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT n FROM User n", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findOne(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }

}
