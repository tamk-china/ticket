package com.tamk.ticket.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@ResponseBody
	@RequestMapping(value = "/queryTickets", method = RequestMethod.GET)
	public TicketVo queryTickets(@RequestParam(value = "id") Long id, @RequestParam(value = "title") String title) {
		log.warn(id + "-" + title);

		TicketVo ret = new TicketVo();
		ret.setStartAddress("hello spring mvc");
		ret.setEndAddress("hello spring mvc");
		return ret;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) {
		try {
			file.transferTo(new File(file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
