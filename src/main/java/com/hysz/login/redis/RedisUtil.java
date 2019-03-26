package com.hysz.login.redis;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	Logger log=LoggerFactory.getLogger(RedisUtil.class);
	@Autowired
	StringRedisTemplate redis;
	static String ip="";
	static {
		try {
			InetAddress net=InetAddress.getLocalHost();
			ip=net.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public void set(String key,String value){
		redis.opsForValue().set(key, value, 60*5);
		log.info("{}===============set({},{},60*5)",ip,key,value);
	}
	public String get(String key){
		String value=redis.opsForValue().get(key);
		log.info("{}===============get({})={}",ip,key,value);
		return value;
	}
	public void delete(String key){
		redis.delete(key);
		log.info("{}===============delete({})",ip,key);
	}
}
