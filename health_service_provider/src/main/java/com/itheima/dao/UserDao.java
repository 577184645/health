package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @author: qincan
 * @create: 2021-01-14 13:15
 * @description:
 * @version: 1.0
 */

public interface UserDao {

    User findByUsername(String username);

}
