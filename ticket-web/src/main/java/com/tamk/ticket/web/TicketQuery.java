package com.tamk.ticket.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import com.tamk.ticket.manager.CacheManager;
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

	@Resource
	private CacheManager cacheManager;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request) {
		User user = new User();
		user.setId(123);
		user.setName("tamk");
		cacheManager.put("test", user);
		cacheManager.put("xx", user);

		return cacheManager.mget(Arrays.asList("test", "xx"));
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

	public static class User implements Serializable {
		private static final long serialVersionUID = 7989705661451798882L;
		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
