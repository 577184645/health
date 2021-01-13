package com.itheima.service;

import com.itheima.entity.Result;

import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-01-13 9:57
 * @description:  订单接口
 * @version: 1.0
 */

public interface OrderService {

    Result order(Map map) throws Exception;

    Map findById(Integer id) throws Exception;;
}
