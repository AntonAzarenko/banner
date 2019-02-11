package com.azarenko.web.controller;

import com.azarenko.service.UserService;
import com.azarenko.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST, value = "new")
    public String add(UserTO userTo, Model model) {
        if (userTo.getId() == 0) {
            if (service.add(userTo.asUser())) {
                model.addAttribute("message", "Вы успешно зарeгистрировались. Пожалуйста авторизуйтесь");
            } else {
                model.addAttribute("message", "Пользователь с таким логином уже сужествует");
                return "loginPage";
            }
        }
        return "startPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "logout")
    public String logout() {
        return "";
    }
}
