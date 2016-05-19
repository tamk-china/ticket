package com.tamk.ticket.rpc.impl;

import javax.annotation.Resource;

import com.tamk.ticket.rpc.TestConsumer;
import com.tamk.ticket.rpc.TestProvider;

public class TestConsumerImpl implements TestConsumer{
	@Resource
	private TestProvider provider;

	@Override
	public void say() {
		System.out.println(provider.sayHello("messi"));
	}
}
