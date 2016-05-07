package com.tamk.ticket.dal.model.query;

import java.util.List;

/**
 * @author kuanqiang.tkq
 */
public class TrainQuery extends BaseQuery {
	private Long id;
	private String trainNick;
	private Integer status;
	private String description;
	private List<Long> idList;

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

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}

}
