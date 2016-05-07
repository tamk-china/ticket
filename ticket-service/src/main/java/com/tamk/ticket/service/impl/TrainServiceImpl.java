package com.tamk.ticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tamk.ticket.dal.TrainMapper;
import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.dal.model.query.TrainQuery;
import com.tamk.ticket.domain.Train;
import com.tamk.ticket.service.TrainService;

@Service("trainService")
public class TrainServiceImpl implements TrainService {
	private Logger log = LoggerFactory.getLogger(TrainServiceImpl.class);

	@Resource
	private TrainMapper trainMapper;

	@Override
	public List<Train> queryTrain(TrainQuery trainQuery) {
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
		TrainDO trainDo = TrainDO.fromTrain(train);
		trainMapper.insertTrain(trainDo);
		return trainDo.getId();
	}

	@Override
	public boolean batchInsertTrain(List<Train> trains) {
		List<TrainDO> trainDos = new ArrayList<TrainDO>();
		for (Train one : trains) {
			trainDos.add(TrainDO.fromTrain(one));
		}

		try {
			trainMapper.batchInsertTrain(trainDos);
			return true;
		} catch (Exception e) {
			log.error(String.format("batchInsertTrain trainMapper batchInsertTrain fail [trainDos = %s] [msg = %s] [exception = %s]", JSON.toJSONString(trainDos), e.getMessage(),
					ExceptionUtils.getStackTrace(e)));
			return false;
		}
	}

	@Override
	public int updateTrain(Train train) {
		return trainMapper.updateTrain(TrainDO.fromTrain(train));
	}

	@Override
	public int deleteTrain(TrainQuery trainQuery) {
		return trainMapper.deleteTrain(trainQuery);
	}
}
