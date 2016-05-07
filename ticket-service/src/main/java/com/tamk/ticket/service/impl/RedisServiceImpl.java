package com.tamk.ticket.service.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.tamk.ticket.service.RedisService;

/**
 * @author kuanqiang.tkq
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
	private Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

	private Jedis jedis;

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	@Override
	public <T> T get(String key) {
		if (StringUtils.isEmpty(key)) {
			throw new IllegalArgumentException();
		}

		byte[] value = jedis.get(key.getBytes());
		if (null == value || 0 == value.length) {
			return null;
		}

		return SerializationUtils.deserialize(value);
	}

	public static final String RET_CODE_OK = "OK";

	@Override
	public <T extends Serializable> boolean put(String key, T value) {
		if (StringUtils.isEmpty(key) || null == value) {
			throw new IllegalArgumentException();
		}

		String retCode = jedis.set(key.getBytes(), SerializationUtils.serialize(value));
		if (!RET_CODE_OK.equals(retCode)) {
			log.error(String.format("set fail [key = %s] [value = %s] [retCode = %s]", key, value.toString(), retCode));
			return false;
		}

		return true;
	}

	@Override
	public <T extends Serializable> boolean put(String key, T value, int expireSeconds) {
		if(StringUtils.isEmpty(key) || null ==value || expireSeconds < 1){
			throw new IllegalArgumentException();
		}
		
		String retCode = jedis.setex(key.getBytes(), expireSeconds, SerializationUtils.serialize(value));
		if (!RET_CODE_OK.equals(retCode)) {
			log.error(String.format("setex fail [key = %s] [value = %s] [retCode = %s]", key, value.toString(), retCode));
			return false;
		}
		
		return true;
	}
}
