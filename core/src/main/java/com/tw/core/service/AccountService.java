package com.tw.core.service;

import com.tw.core.Account;
import com.tw.core.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class AccountService {
    private AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Transactional
    public List<Account> listAccount() {
        return accountDAO.listAccount();
    }

    @Transactional
    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    @Transactional
    public Account findAccountById(long id) {
        return accountDAO.findAccountById(id);
    }

    @Transactional
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    @Transactional
    public void deleteAccount(long id) {
        accountDAO.deleteAccount(id);
    }

    @Transactional
    public void deleteAccountList(long[] ids) {
        accountDAO.deleteAccountList(ids);
    }

    @Transactional
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Transactional
    public Account findOne(long id) {
        return accountDAO.findOne(id);
    }

    @Transactional
    public void create(Account account) {
        accountDAO.create(account);
    }

    @Transactional
    public void delete(long id) {
        accountDAO.delete(id);
    }

    @Transactional
    public void update(Account account) {
        accountDAO.update(account);
    }

    @Transactional
    public void deleteAll(long[] idList) {
        accountDAO.deleteAll(idList);
    }

    @Transactional
    public List<Account> search(String keyword) {
        return accountDAO.search(keyword);
    }
}
