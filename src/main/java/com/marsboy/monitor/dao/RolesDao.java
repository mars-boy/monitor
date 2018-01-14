package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.Roles;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDao extends  AbstractDesignDao<Roles,Byte>{
    Roles getRoleByName(String roleName);
}
