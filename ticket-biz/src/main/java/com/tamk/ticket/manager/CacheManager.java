package com.tamk.ticket.manager;

import java.io.Serializable;

/**
 * @author kuanqiang.tkq
 */
public interface CacheManager {

	<T> T get(String key);

	<T extends Serializable> boolean put(String key, T value);

}
