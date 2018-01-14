package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends AbstractDesignDao<User,Long> {
    List<User> getUserByUserName(String username);
}
