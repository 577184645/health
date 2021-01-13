package com.itheima.dao;

import com.itheima.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-01-13 10:46
 * @description:
 * @version: 1.0
 */

public interface OrderDao {
    public void add(Order order);
    public List<Order> findByCondition(Order order);

    Map findById4Detail(Integer id);

}
