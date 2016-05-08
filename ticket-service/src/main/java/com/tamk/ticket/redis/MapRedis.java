package com.tamk.ticket.redis;

import java.io.Serializable;


public interface MapRedis {

	<K extends Serializable, V extends Serializable> void put(String mapKey, K key, V value);

	<K extends Serializable, V extends Serializable> V put(String mapKey, K key);

	long size(String mapKey);

}
