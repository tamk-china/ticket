package com.tamk.ticket.manager.impl;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tamk.ticket.manager.FileManager;
import com.tamk.ticket.service.FileService;

/**
 * @author kuanqiang.tkq
 */
@Service("fileManager")
public class FileManagerImpl implements FileManager {
	@Resource
	private FileService fileService;

	@Override
	public void saveFile2Local(String path, InputStream stream) {
		fileService.saveFile2Local(path, stream);
	}
}
