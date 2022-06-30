package com.redis;

import com.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.Dao.courseDao;
import java.util.List;
import java.util.Map;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */
public class AddToRedis {
    static JedisPool jedisPool = JedisUtil.redisPoolFactory();  // 连接池
    static Jedis jedis = null;

    public static void addStuId(int id){
        jedis = jedisPool.getResource();    // 返回一个jedis对象
        jedis.set("stu_id", id + "");
        jedis.expire("stu_id", 3600);
    }

    public static void addAllCourse(){
        jedis = jedisPool.getResource();    // 返回一个jedis对象
        List<Map<String, Object>> course = courseDao.findAllCourse();
        for (Map<String, Object> stringObjectMap : course) {
            jedis.rpush("course", stringObjectMap + "");
        }
        jedis.expire("course", 3600);
    }

}
