package com.tamk.ticket.dal.model;

import java.util.Date;

public class TrainDO{
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	private String trainNick;
	private Integer status;
	private String desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getTrainNick() {
		return trainNick;
	}

	public void setTrainNick(String trainNick) {
		this.trainNick = trainNick;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
