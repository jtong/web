package com.tw.core.service;

import com.tw.core.User;
import com.tw.core.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class UserService {
    private UserDAO userDAO;
    
    private PasswordService passwordService;

    @Autowired
    public UserService(UserDAO userDAO, PasswordService passwordService) {
        this.userDAO = userDAO;
        this.passwordService = passwordService;
    }

    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public User findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    public void deleteUserList(long[] ids) {
        userDAO.deleteUserList(ids);
    }


    public User auth(String userName, String password) {
        return userDAO.auth(userName, passwordService.encrypt(password));
    }

    @Transactional
    public List<User> search(String keyword) {
        return userDAO.search(keyword);
    }

}
