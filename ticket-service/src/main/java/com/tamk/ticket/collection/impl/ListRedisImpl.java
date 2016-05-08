package com.tamk.ticket.collection.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

import com.tamk.ticket.collection.ListRedis;

/**
 * @author kuanqiang.tkq
 */
@Repository("listRedis")
public class ListRedisImpl implements ListRedis {
	@Resource
	private Jedis jedis;

	@Override
	public <T extends Serializable> void push(String key, T value) {
		if (StringUtils.isEmpty(key) || null == value) {
			throw new IllegalArgumentException();
		}

		jedis.rpush(key.getBytes(), SerializationUtils.serialize(value));
	}

	@Override
	public <T extends Serializable> T get(String key) {
		if (StringUtils.isEmpty(key)) {
			throw new IllegalArgumentException();
		}

		byte[] value = jedis.lpop(key.getBytes());
		if (null == value || 0 == value.length) {
			return null;
		}

		return SerializationUtils.deserialize(value);
	}

	@Override
	public long size(String key) {
		if (StringUtils.isEmpty(key)) {
			throw new IllegalArgumentException();
		}

		return jedis.llen(key.getBytes());
	}
}
