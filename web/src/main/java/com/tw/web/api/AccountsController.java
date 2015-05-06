package com.tw.web.api;

import com.tw.core.Account;
import com.tw.core.service.AccountService;
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
@RequestMapping("/api/v1/accounts")
public class AccountsController {
    private AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> findOne(@PathVariable("accountId") long id) {
        Account account = accountService.findOne(id);

        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) {
        accountService.create(account);
        response.setHeader("Location", request.getRequestURL().append("/").append(account.getId()).toString());
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("accountId") long id, @RequestBody Account account) {
        accountService.update(account);
    }


    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("accountId") long id) {
        accountService.delete(id);
    }

    @RequestMapping(value = "/:batch", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@RequestBody long[] ids) {
        accountService.deleteAll(ids);
    }

    @RequestMapping(value = "/:search", method = RequestMethod.GET)
    public List<Account> search( @RequestParam(value = "keyword") String keyword) {
        return accountService.search(keyword);
    }

}
