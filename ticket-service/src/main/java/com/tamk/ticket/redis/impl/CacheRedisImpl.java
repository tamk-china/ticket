package com.tamk.ticket.redis.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tamk.ticket.redis.CacheRedis;

/**
 * @author kuanqiang.tkq
 */
public class CacheRedisImpl extends JedisParent implements CacheRedis {
	private Logger log = LoggerFactory.getLogger(CacheRedisImpl.class);

	@Override
	public <T extends Serializable> T get(String key) {
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
		if (StringUtils.isEmpty(key) || null == value || expireSeconds < 1) {
			throw new IllegalArgumentException();
		}

		String retCode = jedis.setex(key.getBytes(), expireSeconds, SerializationUtils.serialize(value));
		if (!RET_CODE_OK.equals(retCode)) {
			log.error(String.format("setex fail [key = %s] [value = %s] [retCode = %s]", key, value.toString(), retCode));
			return false;
		}

		return true;
	}

	@Override
	public <T extends Serializable> Map<String, T> mget(List<String> keys) {
		if (null == keys || keys.isEmpty()) {
			throw new IllegalArgumentException();
		}

		byte[][] keysArr = new byte[keys.size()][];
		for (int i = 0; i < keys.size(); ++i) {
			keysArr[i] = keys.get(i).getBytes();
		}

		List<byte[]> values = jedis.mget(keysArr);

		Map<String, T> result = new HashMap<String, T>();
		for (int i = 0; i < keys.size(); ++i) {
			String key = keys.get(i);
			byte[] value = values.get(i);
			if (null == value || 0 == value.length) {
				continue;
			}

			result.put(key, SerializationUtils.<T> deserialize(value));
		}

		return result;
	}
	
	@Override
	public void increase(String key){
		if(StringUtils.isEmpty(key)){
			throw new IllegalArgumentException();
		}
		
		jedis.incr(key.getBytes());
	}
	
	@Override
	public void decreate(String key){
		if(StringUtils.isEmpty(key)){
			throw new IllegalArgumentException();
		}
		
		jedis.decr(key.getBytes());
	}
	
	@Override
	public Long getNum(String key){
		if(StringUtils.isEmpty(key)){
			throw new IllegalArgumentException();
		}
		
		String numStr = jedis.get(key);
		return Long.parseLong(numStr);
	}
}
