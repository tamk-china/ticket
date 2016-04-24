package com.tamk.ticket.service.impl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import com.tamk.ticket.service.FileService;

/**
 * @author kuanqiang.tkq
 */
@Repository("fileService")
public class FileServiceImpl implements FileService {
	@Override
	public void saveFile2Local(String path, InputStream stream) throws IOException{
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
		IOUtils.copy(stream, bos);
	}
}
