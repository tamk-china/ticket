package com.tamk.ticket.collection;

import java.io.Serializable;

/**
 * @author kuanqiang.tkq
 */
public interface ListRedis {

	<T extends Serializable> void push(String key, T value);

	<T extends Serializable> T get(String key);

	long size(String key);

}
