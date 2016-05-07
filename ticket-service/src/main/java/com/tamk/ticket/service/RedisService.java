package com.tamk.ticket.service;

import java.io.Serializable;

/**
 * @author kuanqiang.tkq
 */
public interface RedisService {

	<T> T get(String key);

	<T extends Serializable> boolean put(String key, T value);

	<T extends Serializable> boolean put(String key, T value, int expireSeconds);

}
