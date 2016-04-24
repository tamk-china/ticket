package com.tamk.ticket.service.impl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tamk.ticket.service.FileService;

/**
 * @author kuanqiang.tkq
 */
@Repository("fileService")
public class FileServiceImpl implements FileService {
	private Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

	@Override
	public void saveFile2Local(String path, InputStream stream) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			IOUtils.copy(stream, bos);
		} catch (IOException e) {
			log.error("saveFile2Local exception [path = %s] [msg = %s] [exception = %s]", path, e.getMessage(), ExceptionUtils.getStackTrace(e));
		} finally {
			if (null != bos) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
