package com.tw.core.service;

import com.tw.core.Customer;
import com.tw.core.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    public List<Customer> listCustomer() {
        return customerDAO.listCustomer();
    }

    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Transactional
    public Customer findCustomerById(long id) {
        return customerDAO.findCustomerById(id);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(long id) {
        customerDAO.deleteCustomer(id);
    }

    @Transactional
    public void deleteCustomerList(long[] ids) {
        customerDAO.deleteCustomerList(ids);
    }
    
    @Transactional
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Transactional
    public Customer findOne(long id) {
        return customerDAO.findOne(id);
    }

    @Transactional
    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    @Transactional
    public void delete(long id) {
        customerDAO.delete(id);
    }

    @Transactional
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Transactional
    public void deleteAll(long[] idList) {
        customerDAO.deleteAll(idList);
    }

    @Transactional
    public List<Customer> search(String keyword) {
        return customerDAO.search(keyword);
    }
}
