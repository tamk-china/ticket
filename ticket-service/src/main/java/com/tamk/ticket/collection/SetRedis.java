package com.tamk.ticket.collection;

import java.io.Serializable;

public interface SetRedis {

	<T extends Serializable> void add(String key, T value);

	<T extends Serializable> void remove(String key, T value);

	<T extends Serializable> boolean contain(String key, T value);

	long size(String key);

}
