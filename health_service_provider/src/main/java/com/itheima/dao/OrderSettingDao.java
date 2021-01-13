package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-01-08 9:51
 * @description:  预约设置持久层
 * @version: 1.0
 */

public interface OrderSettingDao {

    void add(OrderSetting orderSetting);
    public void editNumberByOrderDate(OrderSetting orderSetting);
    public int findCountByOrderDate(Date orderDate);
    public List<OrderSetting> getOrderSettingByMonth(Map date);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);

}
