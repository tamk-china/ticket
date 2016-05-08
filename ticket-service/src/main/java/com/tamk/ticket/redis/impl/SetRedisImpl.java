package com.tamk.ticket.redis.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import com.tamk.ticket.redis.SetRedis;

/**
 * @author kuanqiang.tkq
 */
public class SetRedisImpl extends JedisParent implements SetRedis {
	@Override
	public <T extends Serializable> void add(String key, T value) {
		if (StringUtils.isEmpty(key) || null == value) {
			throw new IllegalArgumentException();
		}

		jedis.sadd(key.getBytes(), SerializationUtils.serialize(value));
	}

	@Override
	public <T extends Serializable> void remove(String key, T value) {
		if (StringUtils.isEmpty(key) || null == value) {
			throw new IllegalArgumentException();
		}

		jedis.srem(key.getBytes(), SerializationUtils.serialize(value));
	}

	@Override
	public <T extends Serializable> boolean contain(String key, T value) {
		if(StringUtils.isEmpty(key) || null == value){
			throw new IllegalArgumentException();
		}
		
		return jedis.sismember(key.getBytes(), SerializationUtils.serialize(value));
	}

	@Override
	public long size(String key) {
		if(StringUtils.isEmpty(key)){
			throw new IllegalArgumentException();
		}
		
		return jedis.scard(key.getBytes());
	}
}
