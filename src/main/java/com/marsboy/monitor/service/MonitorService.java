package com.marsboy.monitor.service;

import com.marsboy.monitor.dao.CategoriesDao;
import com.marsboy.monitor.dao.ExpensesDao;
import com.marsboy.monitor.dao.RolesDao;
import com.marsboy.monitor.dao.UserDao;
import com.marsboy.monitor.model.Categories;
import com.marsboy.monitor.model.Expenses;
import com.marsboy.monitor.model.Roles;
import com.marsboy.monitor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MonitorService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private RolesDao rolesDao;

    @Autowired
    private CategoriesDao categoriesDao;

    @Autowired
    private ExpensesDao expensesDao;

    public List<User> getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    public Roles getRoleByName(String roleName) { return rolesDao.getRoleByName(roleName); }

    public void saveOrupdateUser(User user) {
        userDao.saveOrupdate(user);
    }

    public List<Categories> getAllCategories() {
        return categoriesDao.getAllCategories();
    }

    public void saveExpense(Expenses expenses) {
        expensesDao.save(expenses);
    }

    public List<Expenses> getAllExpensesActive(Long userId) {
        return expensesDao.getAllExpensesActive(userId);
    }

    public List<Expenses> getUserExpenseToCategoryActive(Long userId) {
        return expensesDao.getUserExpenseToCategoryActive(userId);
    }

    public List<Expenses> getAllExpensesActiveFromTo(Long userid, String from, String to) {
        return expensesDao.getAllExpensesActiveFromTo(userid,from,to);
    }
}
