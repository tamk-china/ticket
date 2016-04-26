package com.tamk.ticket.web;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tamk.ticket.manager.FileManager;
import com.tamk.ticket.manager.TrainManager;
import com.tamk.ticket.web.vo.TicketVo;

/**
 * ticket访问controller
 * 
 * @author kuanqiang.tkq
 */
@Controller
@RequestMapping("/ticket")
public class TicketQuery {
	private Logger log = LoggerFactory.getLogger(TicketQuery.class);

	@Resource
	private FileManager fileManager;

	@Resource
	private ApplicationContext applicationContext;

	@Resource
	private TrainManager trainManager;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Object test() {
		Object ret = trainManager.queryTrain();
		return ret;
	}

	@ResponseBody
	@RequestMapping(value = "/queryTickets", method = RequestMethod.GET)
	public TicketVo queryTickets(@RequestParam(value = "id") Long id, @RequestParam(value = "title") String title) {
		log.warn(id + "-" + title);

		for (String str : applicationContext.getBeanDefinitionNames()) {
			System.out.println(str);
		}

		TicketVo ret = new TicketVo();
		ret.setStartAddress("hello spring mvc");
		ret.setEndAddress("hello spring mvc");
		return ret;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) {
		try {
			fileManager.saveFile2Local(file.getOriginalFilename(), file.getInputStream());
		} catch (IOException e) {
			log.error(String.format("uploadFile exception [msg = %s] [exception = %s]", e.getMessage(), ExceptionUtils.getStackTrace(e)));
		}
	}
}
