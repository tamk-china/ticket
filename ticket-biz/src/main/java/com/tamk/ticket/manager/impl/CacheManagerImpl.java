package com.tamk.ticket.manager.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.manager.CacheManager;
import com.tamk.ticket.service.RedisService;

/**
 * @author kuanqiang.tkq
 */
@Service("cacheManager")
public class CacheManagerImpl implements CacheManager {
	@Resource
	private RedisService redisService;

	@Override
	public <T extends Serializable>  T get(String key) {
		return redisService.get(key);
	}

	@Override
	public <T extends Serializable> boolean put(String key, T value) {
		return redisService.put(key, value);
	}

	@Override
	public <T extends Serializable>  Map<String, T> mget(List<String> keys){
		return redisService.mget(keys);
	}
}
