package com.itheima.jobs;

import com.itheima.entity.RedisConstant;
import com.itheima.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author: qincan
 * @create: 2021-01-07 15:48
 * @description: 自定义Job，实现定时清理垃圾图片
 * @version: 1.0
 */

public class ClearImgJob {
    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        Jedis jedis=jedisPool.getResource();
        Set<String> set=jedis.sdiff(RedisConstant.SETMEAL_PIC_RESOURCES,
                RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if(set!=null){
            for (String picName : set) {
                //删除七牛云服务器上的图片
                QiniuUtils.deleteFileFromQiniu(picName);
                //从Redis集合中删除图片名称
                jedis.srem(RedisConstant.SETMEAL_PIC_RESOURCES,picName);
            }
        }
        jedis.close();
    }
}
