package com.tamk.ticket.domain;

/**
 * train的domain对象
 * 
 * @author kuanqiang.tkq
 */
public class Train {
	private Long id;
	private String trainNick;
	private Integer status;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainNick=" + trainNick + ", status=" + status + ", description=" + description + "]";
	}

}
