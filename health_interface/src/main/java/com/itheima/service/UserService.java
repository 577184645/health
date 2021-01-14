package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @author: qincan
 * @create: 2021-01-14 13:12
 * @description: 用户接口
 * @version: 1.0
 */

public interface UserService {

    User findByUsername(String username);
}
