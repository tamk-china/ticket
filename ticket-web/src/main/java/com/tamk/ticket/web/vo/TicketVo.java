package com.tamk.ticket.web.vo;

import java.io.Serializable;

/**
 * @author kuanqiang.tkq
 */
public class TicketVo implements Serializable{
	private static final long serialVersionUID = -8827355106148922171L;
	private String startAddress;
	private String endAddress;

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

}
