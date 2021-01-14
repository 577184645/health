package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.Set;

/**
 * @author: qincan
 * @create: 2021-01-14 13:24
 * @description:
 * @version: 1.0
 */

public interface PermissionDao {
    public Set<Permission> findByRoleId(int roleId);
}
