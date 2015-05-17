package com.tw.web.api;

import com.tw.core.Customer;
import com.tw.core.service.CustomerService;
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
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findOne(@PathVariable("customerId") long id) {
        Customer customer = customerService.findOne(id);

        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response) {
        customerService.create(customer);
        response.setHeader("Location", request.getRequestURL().append("/").append(customer.getId()).toString());
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("customerId") long id, @RequestBody Customer customer) {
        customerService.update(customer);
    }


    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("customerId") long id) {
        customerService.delete(id);
    }

    @RequestMapping(value = "/:batch", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@RequestBody long[] ids) {
        customerService.deleteAll(ids);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Customer> search( @RequestParam(value = "keyword") String keyword) {
        return customerService.search(keyword);
    }

}
