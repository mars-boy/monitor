package com.marsboy.monitor.controller;

import com.marsboy.monitor.model.Roles;
import com.marsboy.monitor.model.User;
import com.marsboy.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MonitorService monitorService;

    /* Getting request during startup to redirect to login page */
    @RequestMapping(value = {"/","login"},method = RequestMethod.GET)
    public String goLogin(Model model){
        return "login";
    }

    /* Redirect to register page */
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String goRegister(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    /* On successful login user redirects to homepage*/
    @RequestMapping(value = "/common/home",method = RequestMethod.GET)
    public String login(){
        return "common/home";
    }

    /* Check if username is available ajax request from JQuery */
    @RequestMapping(value = "/ajax/chkuser",method = RequestMethod.GET)
    @ResponseBody
    public String checkUsernameExists(@RequestParam("username") String username){
        List<User> userList = monitorService.getUserByUserName(username);
        if(userList  != null){
            return "found";
        }else{
            return "notfound";
        }
    }

    /* Register user with data provided ...*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult bindingResult,Model model){
        List<User> userList = monitorService.getUserByUserName(user.getUsername());
        if(userList != null){
            model.addAttribute("message","Sorry Username exists.");
            model.addAttribute("user",new User());
            return "registration";
        }else{
            user.setActive(true);
            Roles role = monitorService.getRoleByName("ADMIN");
            if(role == null){
                model.addAttribute("user",new User());
                model.addAttribute("message","Sorry something bad happened.");
                return "registration";
            }else{
                String password = user.getPassword();
                user.setPassword(bCryptPasswordEncoder.encode(password));
                user.setActive(true);
                user.setRoles(role);
                monitorService.saveOrupdate(user);
                model.addAttribute("message","User Creation Successful.");
                model.addAttribute("user",new User());
                return "registration";
            }
        }
    }
}
