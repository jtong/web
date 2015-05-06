package com.tw.core.service;

import com.tw.core.Employee;
import com.tw.core.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public List<Employee> listEmployee() {
        return employeeDAO.listEmployee();
    }

    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Transactional
    public Employee findEmployeeById(long id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }

    @Transactional
    public void deleteEmployeeList(long[] ids) {
        employeeDAO.deleteEmployeeList(ids);
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    public Employee findOne(long id) {
        return employeeDAO.findOne(id);
    }

    @Transactional
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Transactional
    public void delete(long id) {
        employeeDAO.delete(id);
    }

    @Transactional
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Transactional
    public void deleteAll(long[] idList) {
        employeeDAO.deleteAll(idList);
    }

    @Transactional
    public List<Employee> search(String keyword) {
        return employeeDAO.search(keyword);
    }
}
