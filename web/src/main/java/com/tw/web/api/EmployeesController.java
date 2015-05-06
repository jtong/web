package com.tw.web.api;

import com.tw.core.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by twer on 7/24/14.
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Employee> findOne(@PathVariable("employeeId") long id) {
        Employee employee = employeeService.findOne(id);

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee employee, HttpServletRequest request, HttpServletResponse response) {
        employeeService.create(employee);
        response.setHeader("Location", request.getRequestURL().append("/").append(employee.getId()).toString());
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("employeeId") long id, @RequestBody Employee employee) {
        employeeService.update(employee);
    }


    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("employeeId") long id) {
        employeeService.delete(id);
    }

    @RequestMapping(value = "/:batch", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@RequestBody long[] ids) {
        employeeService.deleteAll(ids);
    }

    @RequestMapping(value = "/:search", method = RequestMethod.GET)
    public List<Employee> search( @RequestParam(value = "keyword") String keyword) {
        return employeeService.search(keyword);
    }

}
