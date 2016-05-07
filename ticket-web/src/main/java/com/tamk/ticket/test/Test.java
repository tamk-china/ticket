package com.tamk.ticket.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<MemoryPoolMXBean> list = ManagementFactory.getMemoryPoolMXBeans();
		for(MemoryPoolMXBean one : list){
			System.out.println(one.getName() + "-"+one.getType());			
		}
	}

}
