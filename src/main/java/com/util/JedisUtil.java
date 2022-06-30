package com.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */
public class JedisUtil {
    //服务器地址
    private static final String host = "8.130.17.147";
    //端口
    private static final int port = 6379;
    //密码
    private static final String password = "qhsruan";
    //超时时间
    private static final String timeout = "1000000";
    //最大连接数
    private static final int maxTotal = 1024;
    //最大连接阻塞等待时间
    private static final String maxWaitMillis = "100000ms";
    //最大空闲连接
    private static final int maxIdle = 200;
    //最小空闲连接
    private static final int minIdle = 5;

    public static JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(maxWaitMillis.substring(0,
                maxWaitMillis.length() - 2)));
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,
                Integer.parseInt(timeout.substring(0, timeout.length() - 2)), password);
        return jedisPool;
    }
}
