package com.marsboy.monitor.controller;

import com.marsboy.monitor.model.Categories;
import com.marsboy.monitor.model.Expenses;
import com.marsboy.monitor.model.User;
import com.marsboy.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExpensesController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value = "/expenses")
    public String toExpensesPage(Model model) {
        List<Categories>  categoriesList = monitorService.getAllCategories();
        model.addAttribute("expenses",new Expenses());
        if(categoriesList != null) {
            model.addAttribute("categories",categoriesList);
        }
        return "common/expensespage";
    }

    @RequestMapping(value="/ajax/addExpense",method = RequestMethod.POST)
    @ResponseBody
    public String addExpense(@Valid Expenses expenses){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = monitorService.getUserByUserName(authentication.getName()).get(0);
        expenses.setStatus(true);
        expenses.setUser(user);
        monitorService.saveExpense(expenses);
        return "success";
    }
}
