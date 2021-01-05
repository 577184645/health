package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

/**
 * @author: qincan
 * @create: 2021-01-05 14:51
 * @description: 持久层Dao接口
 * @version: 1.0
 */

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    Page<CheckItem> selectByCondition(String queryString);
}
