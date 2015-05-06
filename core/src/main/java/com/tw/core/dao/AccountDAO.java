package com.tw.core.dao;

import com.tw.core.Account;
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
public class AccountDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Account> listAccount() {
        return sessionFactory.getCurrentSession().createQuery("from Account")
                .list();
    }

    public void addAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    public Account findAccountById(long id) {
        Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, id);
        return account;
    }

    public void updateAccount(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }

    public void deleteAccount(long id) {
        Account account = findAccountById(id);
        if (account != null) {
            sessionFactory.getCurrentSession().delete(account);
        }
    }

    public void deleteAccountList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteAccount(ids[index]);
        }
    }

    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Account")
                .list();
    }

    public Account findOne(long id) {
        Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, id);
        return account;
    }

    public void create(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    public void delete(long id) {
        Account account = findOne(id);
        if (account != null) {
            sessionFactory.getCurrentSession().delete(account);
        }
    }

    public void update(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<Account> search(String keyword) {
        String query = "FROM Account WHERE name LIKE :keyword or email LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }
}
