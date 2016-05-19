package com.tamk.ticket.rpc.impl;

import com.tamk.ticket.rpc.TestProvider;

public class TestProviderImpl implements TestProvider {
	@Override
	public String sayHello(String name) {
		return "best player: " + name;
	}
}
