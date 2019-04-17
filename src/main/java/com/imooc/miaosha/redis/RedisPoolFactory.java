package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @version:1.0
 * @author: wulinfei
 * @date:2019年3月28日 下午12:25:49
 * @name:redis数据库连接池工厂类
 * @Description:
 */
@Service
public class RedisPoolFactory {
	@Autowired
	RedisConfig redisConfig;
	@Bean 
	public JedisPool JedisPoolFactory(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
		
		JedisPool jp = new JedisPool(poolConfig,redisConfig.getHost(),redisConfig.getPort(),
				redisConfig.getTimeout()* 1000,redisConfig.getPassword(),0);
		return jp;
	}
}
