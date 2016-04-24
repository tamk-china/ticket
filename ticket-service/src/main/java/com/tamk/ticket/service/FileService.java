package com.tamk.ticket.service;

import java.io.InputStream;

/**
 * @author kuanqiang.tkq
 */
public interface FileService {
	void saveFile2Local(String path, InputStream stream);
}
