package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.UserDao;
import com.marsboy.monitor.model.Roles;
import com.marsboy.monitor.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDesignDaoImpl<User,Long> implements UserDao{

    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public List<User> getUserByUserName(String username) {
        Query query = getCurrentSession().createQuery("from User where username=:username");
        query.setString("username",username);
        List<User> userList = query.list();
        if(userList != null ) {
            return userList;
        }
        return null;
    }

    @Override
    public Roles getRoleByName(String roleName) {
        Query query = getCurrentSession().createQuery("from Roles where rolename=:rolename");
        query.setString("rolename",roleName);
        List<Roles> userList = query.list();
        if(userList.size()>0) {
            return userList.get(0);
        }
        return null;
    }
}
