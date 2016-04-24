package com.tamk.ticket.manager;

import java.io.InputStream;

/**
 * @author kuanqiang.tkq
 */
public interface FileManager {
	boolean saveFile2Local(String path, InputStream stream);
}
