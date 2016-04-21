package com.tamk.ticket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tamk.ticket.web.vo.TicketVo;

/**
 * ticket访问controller 
 * @author kuanqiang.tkq
 */
@Controller
@RequestMapping("/ticket")
public class TicketQuery {
	@RequestMapping("/queryTickets")
	public TicketVo queryTickets(){
		return null;
	}
}
