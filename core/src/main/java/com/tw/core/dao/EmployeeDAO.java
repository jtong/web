package com.tw.core.dao;

import com.tw.core.Employee;
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
public class EmployeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> listEmployee() {
        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }

    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee findEmployeeById(long id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }

    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void deleteEmployee(long id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    public void deleteEmployeeList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteEmployee(ids[index]);
        }
    }

    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }

    public Employee findOne(long id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }

    public void create(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public void delete(long id) {
        Employee employee = findOne(id);
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<Employee> search(String keyword) {
        String query = "FROM Employee WHERE name LIKE :keyword or email LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }
}
