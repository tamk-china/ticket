package com.tamk.ticket.manager.impl;

import java.io.Serializable;

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
	public <T> T get(String key) {
		return redisService.get(key);
	}

	@Override
	public <T extends Serializable> boolean put(String key, T value) {
		return redisService.put(key, value);
	}
}
