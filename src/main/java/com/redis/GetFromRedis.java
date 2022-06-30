package com.redis;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.Dao.courseDao;
import com.entity.User;
import com.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */
public class GetFromRedis {
    static JedisPool jedisPool = JedisUtil.redisPoolFactory();  // 连接池
    static Jedis jedis = null;

    public static int getStuId(){
        jedis = jedisPool.getResource();    // 返回一个jedis对象
        return Integer.parseInt(jedis.get("stu_id"));
    }
}
