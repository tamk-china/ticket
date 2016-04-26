package com.tamk.ticket.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.dal.TrainMapper;
import com.tamk.ticket.dal.model.TrainDO;
import com.tamk.ticket.manager.TrainManager;

@Service("trainManager")
public class TrainManagerImpl implements TrainManager {
	@Resource
	private TrainMapper trainMapper;

	@Override
	public List<TrainDO> queryTrain(){
		return trainMapper.queryTrain();
	}
}
