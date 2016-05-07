package com.tamk.ticket.manager;

import java.util.List;

import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;

public interface TrainManager {
	List<TrainDO> queryTrain(TrainQuery trainQuery);
}
