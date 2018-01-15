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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExpensesController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value = "/expenses")
    public String toExpensesPage(Model model) {
        Map<Integer,String> categoryMap = new HashMap<Integer, String>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = monitorService.getUserByUserName(authentication.getName()).get(0);
        /* getting Category List This contains both categoryId and categoryname */
        List<Categories>  categoriesList = monitorService.getAllCategories();
        /* Using hashmap to map id to name  so we dont need to iterate categoryList or call to database with category Id..*/
        for(int i = 0; i < categoriesList.size();i++){
            categoryMap.put(categoriesList.get(i).getCategoryid(),categoriesList.get(i).getCategoryname());
        }
        model.addAttribute("expenses",new Expenses());
        if(categoriesList != null) {
            model.addAttribute("categories",categoriesList);
        }
        List<Expenses> expensesList = monitorService.getAllExpensesActive(user.getUserid());
        /*Assigning category object to expenses object*/
        for(int i = 0; i < expensesList.size();i++){
            Categories categories = new Categories();
            categories.setCategoryid(expensesList.get(i).getCategories().getCategoryid());
            categories.setCategoryname(categoryMap.get(expensesList.get(i).getCategories().getCategoryid()));
            expensesList.get(i).setCategories(categories);
        }
        model.addAttribute("expensesList",expensesList);
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
