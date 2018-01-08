package com.marsboy.monitor.controller;

import com.marsboy.monitor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /* Getting request during startup to redirect to login page */
    @GetMapping("/")
    public String goLogin(Model model){
        return "login";
    }

    /* Redirect to register page */
    @GetMapping("/registration")
    public String goRegister(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    /* On successful login user redirects to homepage*/
    @GetMapping("/common/home")
    public String login(){
        return "commmon/home";
    }
}
