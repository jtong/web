package com.tw.core.dao;

import com.tw.core.Customer;
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
public class CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> listCustomer() {
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    public Customer findCustomerById(long id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    public void deleteCustomer(long id) {
        Customer customer = findCustomerById(id);
        if (customer != null) {
            sessionFactory.getCurrentSession().delete(customer);
        }
    }

    public void deleteCustomerList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteCustomer(ids[index]);
        }
    }
    
    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

    public Customer findOne(long id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
        return customer;
    }

    public void create(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    public void delete(long id) {
        Customer customer = findOne(id);
        if (customer != null) {
            sessionFactory.getCurrentSession().delete(customer);
        }
    }

    public void update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<Customer> search(String keyword) {
        String query = "FROM Customer WHERE name LIKE :keyword ";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }
}
