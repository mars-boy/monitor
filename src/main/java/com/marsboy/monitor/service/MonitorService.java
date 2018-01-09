package com.marsboy.monitor.service;

import com.marsboy.monitor.dao.UserDao;
import com.marsboy.monitor.model.Roles;
import com.marsboy.monitor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MonitorService {


    @Autowired
    private UserDao userDao;

    public List<User> getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    public Roles getRoleByName(String roleName) {
        return userDao.getRoleByName(roleName);
    }

    public void saveOrupdate(User user) {
        userDao.saveOrupdate(user);
    }
}
