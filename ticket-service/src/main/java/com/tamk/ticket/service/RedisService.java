package com.tamk.ticket.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author kuanqiang.tkq
 */
public interface RedisService {

	<T extends Serializable> T get(String key);

	<T extends Serializable> boolean put(String key, T value);

	<T extends Serializable> boolean put(String key, T value, int expireSeconds);

	<T extends Serializable> Map<String, T> mget(List<String> keys);

}
