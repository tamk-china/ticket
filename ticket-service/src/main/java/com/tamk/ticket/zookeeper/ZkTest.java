package com.tamk.ticket.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class ZkTest {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk = new ZooKeeper("192.168.0.102:2181", 3000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				System.out.println(event);
			}
		});
		
		Thread.sleep(10000);
		System.out.println("***************************************************************************");
		
		zk.create("/test", "hello zookeeper".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
}
