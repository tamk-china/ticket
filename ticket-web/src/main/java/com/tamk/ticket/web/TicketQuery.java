package com.tamk.ticket.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tamk.ticket.web.vo.TicketVo;


/**
 * ticket访问controller 
 * @author kuanqiang.tkq
 */
@Controller
@RequestMapping("/ticket")
public class TicketQuery {
	private Logger log = LoggerFactory.getLogger(TicketQuery.class);
	
	@ResponseBody
	@RequestMapping("/queryTickets")
	public TicketVo queryTickets(){
		log.warn("test~~~~~~~~~~~~~~~~~");
		
		TicketVo ret = new TicketVo();
		ret.setStartAddress("hello spring mvc");
		ret.setEndAddress("hello spring mvc");
		return ret;
	}
}
