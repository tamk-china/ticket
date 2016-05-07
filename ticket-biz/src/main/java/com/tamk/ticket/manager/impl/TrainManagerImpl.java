package com.tamk.ticket.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;
import com.tamk.ticket.domain.Train;
import com.tamk.ticket.manager.TrainManager;
import com.tamk.ticket.service.TrainService;

@Service("trainManager")
public class TrainManagerImpl implements TrainManager {
	@Resource
	private TrainService trainService;
	
	@Override
	public List<Train> queryTrain(TrainQuery trainQuery){
		return trainService.queryTrain(trainQuery);
	}

	@Override
	public long insertTrain(Train train) {
		return trainService.insertTrain(train);
	}
	
	@Override
	public boolean batchInsertTrain(List<Train> trains){
		return trainService.batchInsertTrain(trains);
	} 
	
	@Override
	public int updateTrain(TrainDO trainDO) {
		return trainService.updateTrain(trainDO);
	}

	@Override
	public int deleteTrain(TrainQuery trainQuery) {
		return trainService.deleteTrain(trainQuery);
	}
}
