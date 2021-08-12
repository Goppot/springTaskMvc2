package dbweb.dao;

import dbweb.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext//(unitName=)
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User usr) {
        entityManager.merge(usr);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
