package com.tamk.ticket.dal;

import java.util.List;

import com.tamk.ticket.dal.model.TrainDO;

public interface TrainMapper {
	List<TrainDO> queryTrain();
}
