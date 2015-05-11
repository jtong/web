package com.tw.core.dao;

import com.tw.core.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Repository
@Transactional(readOnly = true)
public class UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User findUserById(long id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteUser(long id) {
        User user = findUserById(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void deleteUserList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteUser(ids[index]);
        }
    }


    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public User findOne(long id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(long id) {
        User user = findOne(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<User> search(String keyword) {
        String query = "FROM User WHERE name LIKE :keyword or email LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }


    public User auth(String userName, String password) {
        String query = "FROM User WHERE name = :name and password = :password";
        List result = sessionFactory.getCurrentSession().createQuery(query)
                .setString("name", userName)
                .setString("password", password)
                .list();
        return result.size() == 0? null : (User) result.get(0);
    }
}
