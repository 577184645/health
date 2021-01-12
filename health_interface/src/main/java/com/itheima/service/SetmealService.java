package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.Setmeal;

import java.util.List;

/**
 * @author: qincan
 * @create: 2021-01-07 14:05
 * @description:  套餐接口
 * @version: 1.0
 */

public interface SetmealService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    void add(Setmeal setmeal, Integer[] checkgroupIds);

    List<Setmeal> findAll();

    Setmeal findById(int id);
}
