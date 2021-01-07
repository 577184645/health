package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-01-07 14:38
 * @description:  套餐持久层 dao
 * @version: 1.0
 */

public interface SetmealDao {
    public Page<Setmeal> selectByCondition(String queryString);


    void add(Setmeal setmeal);

    public void setSetmealAndCheckGroup(Map<String, Integer> map);



}
