package com.tamk.ticket.manager.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tamk.ticket.manager.FileManager;
import com.tamk.ticket.service.FileService;

/**
 * @author kuanqiang.tkq
 */
@Service("fileManager")
public class FileManagerImpl implements FileManager{
	private Logger log  = LoggerFactory.getLogger(FileManagerImpl.class);
	
	@Resource
	private FileService fileService;
	
	@Override
	public boolean saveFile2Local(String path, InputStream stream){
		try {
			fileService.saveFile2Local(path, stream);
			return true;
		} catch (IOException e) {
			log.error(String.format("saveFile2Local exception [msg = %s] [exception = %s]", e.getMessage(), ExceptionUtils.getStackTrace(e)));
			return false;
		}
	}
}
