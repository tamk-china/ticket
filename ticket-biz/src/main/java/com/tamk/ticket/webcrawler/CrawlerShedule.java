package com.tamk.ticket.webcrawler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("crawlerShedule")
public class CrawlerShedule {
	private Logger log = LoggerFactory.getLogger(CrawlerShedule.class);

	private ExecutorService executorService = Executors.newScheduledThreadPool(10, new CrawlerThreadFactory());

	public void execute(Runnable task) {

	}
}
