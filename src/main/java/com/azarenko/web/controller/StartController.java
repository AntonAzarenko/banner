package com.azarenko.web.controller;

import com.azarenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(Model model){
        model.addAttribute("userName", service.getUserName());
        return "startPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(){
        return "loginPage";
    }

    @RequestMapping(value = "home")
    public String homePage(Model model){
        model.addAttribute("userName", service.getUserName());
        return "startPage";
    }
}
