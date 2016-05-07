package com.tamk.ticket.manager;

import java.util.List;

import com.tamk.ticket.dal.model.query.TrainQuery;
import com.tamk.ticket.domain.Train;

public interface TrainManager {
	List<Train> queryTrain(TrainQuery trainQuery);
	
	long insertTrain(Train train);

	boolean batchInsertTrain(List<Train> trains);

	int updateTrain(Train train);

	int deleteTrain(TrainQuery trainQuery);
}
