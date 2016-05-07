package com.tamk.ticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.dal.TrainMapper;
import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;
import com.tamk.ticket.domain.Train;
import com.tamk.ticket.service.TrainService;

@Service("trainService")
public class TrainServiceImpl implements TrainService {
	@Resource
	private TrainMapper trainMapper;

	@Override
	public List<Train> queryTrain(TrainQuery trainQuery){
		List<TrainDO> trainDos = trainMapper.queryTrain(trainQuery);
		List<Train> trains = new ArrayList<Train>();
		if (null != trainDos) {
			for (TrainDO one : trainDos) {
				trains.add(one.toTrain());
			}
		}

		return trains;
	}

	@Override
	public long insertTrain(Train train) {
		return trainMapper.insertTrain(TrainDO.fromTrain(train));
	}
}
