package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.Set;

/**
 * @author: qincan
 * @create: 2021-01-14 13:17
 * @description:
 * @version: 1.0
 */

public interface RoleDao {
    public Set<Role> findByUserId(int id);
}
