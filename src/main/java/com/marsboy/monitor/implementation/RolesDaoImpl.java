package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.AbstractDesignDao;
import com.marsboy.monitor.dao.RolesDao;
import com.marsboy.monitor.model.Roles;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RolesDaoImpl extends AbstractDesignDaoImpl<Roles,Byte> implements RolesDao{
    public RolesDaoImpl() {
        super(Roles.class);
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
