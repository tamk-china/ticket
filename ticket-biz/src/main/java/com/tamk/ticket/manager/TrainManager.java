package com.tamk.ticket.manager;

import java.util.List;

import com.tamk.ticket.dal.model.TrainDO;

public interface TrainManager {
	List<TrainDO> queryTrain();
}
