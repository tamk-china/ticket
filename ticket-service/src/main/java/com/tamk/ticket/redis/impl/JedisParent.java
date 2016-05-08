package com.tamk.ticket.redis.impl;

import redis.clients.jedis.Jedis;

public class JedisParent {
	protected Jedis jedis;

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

}
