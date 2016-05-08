package com.tamk.ticket.redis.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import com.tamk.ticket.redis.ListRedis;

/**
 * @author kuanqiang.tkq
 */
public class ListRedisImpl extends JedisParent implements ListRedis {
	@Override
	public <T extends Serializable> void push(String key, T value) {
		if (StringUtils.isEmpty(key) || null == value) {
			throw new IllegalArgumentException();
		}

		jedis.rpush(key.getBytes(), SerializationUtils.serialize(value));
	}

	@Override
	public <T extends Serializable> T fetch(String key) {
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
