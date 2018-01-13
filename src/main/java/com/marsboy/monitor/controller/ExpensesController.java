package com.marsboy.monitor.controller;

import com.marsboy.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExpensesController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value = "/expenses")
    public String toExpensesPage(){
        return "common/expensespage";
    }
}
