package com.tamk.ticket.manager.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.manager.CacheManager;
import com.tamk.ticket.redis.CacheRedis;

/**
 * @author kuanqiang.tkq
 */
@Service("cacheManager")
public class CacheManagerImpl implements CacheManager {
	@Resource
	private CacheRedis cacheRedis;

	@Override
	public <T extends Serializable>  T get(String key) {
		return cacheRedis.get(key);
	}

	@Override
	public <T extends Serializable> boolean put(String key, T value) {
		return cacheRedis.put(key, value);
	}

	@Override
	public <T extends Serializable>  Map<String, T> mget(List<String> keys){
		return cacheRedis.mget(keys);
	}
}
