package com.tamk.ticket.dal;

import java.util.List;

import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;

public interface TrainMapper {
	List<TrainDO> queryTrain(TrainQuery trainQuery);
	
	long insertTrain(TrainDO train);
}
