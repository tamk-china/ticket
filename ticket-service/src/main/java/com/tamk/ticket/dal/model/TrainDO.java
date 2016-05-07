package com.tamk.ticket.dal.model;

import java.util.Date;

import com.tamk.ticket.domain.Train;

public class TrainDO {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	private String trainNick;
	private Integer status;
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Train toTrain() {
		Train train = new Train();
		train.setId(id);
		train.setTrainNick(trainNick);
		train.setStatus(status);
		train.setDescription(description);

		return train;
	}
	
	public static TrainDO fromTrain(Train train){
		TrainDO trainDo = new TrainDO();
		trainDo.setId(train.getId());
		trainDo.setDescription(train.getDescription());
		trainDo.setStatus(train.getStatus());
		trainDo.setTrainNick(train.getTrainNick());
		
		return trainDo;
	}
}
