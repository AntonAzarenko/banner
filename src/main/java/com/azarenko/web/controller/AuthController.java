package com.azarenko.web.controller;

import com.azarenko.service.UserService;
import com.azarenko.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST, value = "new")
    public String add(UserTO userTo) {
        if (userTo.getId() == 0) {
            service.add(userTo.asUser());
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "logout")
    public String logout(){
        return "";
    }
}
