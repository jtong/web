package com.tw.web;

import com.tw.core.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class HomeController {
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        String view = "index";
        if(session.getAttribute("currentUser")==null){
            view = "redirect:/";
        }
        ModelAndView modelAndView = new ModelAndView();
        
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpSession session, @RequestParam(value = "user_name") String userName, @RequestParam(value = "password") String password) {
        User current = this.userService.auth(userName, password);
        return (current == null) ? login(session, current) : new ModelAndView("redirect:/");
    }



    private ModelAndView login(HttpSession session, User current) {
        session.setAttribute("currentUser", current);
        return new ModelAndView("redirect:/index");
    }
}
