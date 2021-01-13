package com.itheima.controller;

/**
 * @author: qincan
 * @create: 2021-01-13 9:48
 * @description:
 * @version: 1.0
 */


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.itheima.constant.MessageConstant;
import com.itheima.constant.RedisConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Order;
import com.itheima.service.OrderService;
import com.itheima.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * 体检预约
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private JedisPool jedisPool;
    @Reference
    private OrderService orderService;


    @RequestMapping("/submit")
    public Result submitOrder(@RequestBody Map map){
        String  telephone= (String)map.get("telephone");
        String  validateCode= (String)map.get("validateCode");
        Jedis jedis = jedisPool.getResource();
        String codeInRedis = jedis.get(telephone + RedisConstant.SENDTYPE_ORDER);
        if(codeInRedis==null||!codeInRedis.equals(validateCode)){
          return new Result(false, MessageConstant.VALIDATECODE_ERROR);
       }

        Result result =null;
        try{
            map.put("orderType", Order.ORDERTYPE_WEIXIN);
            result = orderService.order(map);
        }catch (Exception e){
            e.printStackTrace();
            //预约失败
            return result;
        }
        if(result.isFlag()){
            //预约成功，发送短信通知
            String orderDate = (String) map.get("orderDate");
            JSONObject jsonObject = JSONObject.parseObject(orderDate);
            System.out.println(jsonObject.getString("msg"));
            try {
                SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE,telephone,orderDate);
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 根据id查询预约信息，包括套餐信息和会员信息
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Map map = orderService.findById(id);
            //查询预约信息成功
            return new Result(true, MessageConstant.QUERY_ORDER_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            //查询预约信息失败
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }
}
