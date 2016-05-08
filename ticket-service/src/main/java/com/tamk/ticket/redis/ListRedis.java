package com.tamk.ticket.redis;

import java.io.Serializable;

/**
 * @author kuanqiang.tkq
 */
public interface ListRedis {

	<T extends Serializable> void push(String key, T value);

	<T extends Serializable> T fetch(String key);

	long size(String key);

}
