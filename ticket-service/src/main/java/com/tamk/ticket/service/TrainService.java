package com.tamk.ticket.service;

import java.util.List;

import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;
import com.tamk.ticket.domain.Train;

public interface TrainService {
	List<Train> queryTrain(TrainQuery trainQuery);

	long insertTrain(Train train);

	boolean batchInsertTrain(List<Train> trains);

	int updateTrain(TrainDO trainDO);

	int deleteTrain(TrainQuery trainQuery);
}
