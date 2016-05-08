package com.tamk.ticket.collection.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

import com.tamk.ticket.collection.MapRedis;

/**
 * @author kuanqiang.tkq
 */
@Repository("mapRedis")
public class MapRedisImpl implements MapRedis {
	@Resource
	private Jedis jedis;

	@Override
	public <K extends Serializable, V extends Serializable> void put(String mapKey, K key, V value) {
		if (StringUtils.isEmpty(mapKey) || null == key || null == value) {
			throw new IllegalArgumentException();
		}

		jedis.hset(mapKey.getBytes(), SerializationUtils.serialize(key), SerializationUtils.serialize(value));
	}

	@Override
	public <K extends Serializable, V extends Serializable> V put(String mapKey, K key) {
		if (StringUtils.isEmpty(mapKey) || null == key) {
			throw new IllegalArgumentException();
		}

		byte[] value = jedis.hget(mapKey.getBytes(), SerializationUtils.serialize(key));
		if (null == value || 0 == value.length) {
			return null;
		}

		return SerializationUtils.deserialize(value);
	}

	@Override
	public long size(String mapKey) {
		if (StringUtils.isEmpty(mapKey)) {
			throw new IllegalArgumentException();
		}

		return jedis.hlen(mapKey.getBytes());
	}
}
