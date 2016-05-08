package com.tamk.ticket.collection.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

import com.tamk.ticket.collection.SetRedis;

/**
 * @author kuanqiang.tkq
 */
@Repository("setRedis")
public class SetRedisImpl implements SetRedis {
	@Resource
	private Jedis jedis;

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
