package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

/**
 * @author: qincan
 * @create: 2021-01-05 14:48
 * @description: 检查项服务接口
 * @version: 1.0
 */

public interface CheckItemService {
    public void add(CheckItem checkItem);

    PageResult pageQuery(QueryPageBean queryPageBean);
}
