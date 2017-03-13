/*
 * @(#)FileMonitorTest.java	2011-7-13
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core.monitor;

import com.github.javaclub.toolbox.core.monitor.FileMonitor;
import com.github.javaclub.toolbox.util.FileUtil;

import java.io.File;

import org.junit.Test;

/**
 * FileMonitorTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: FileMonitorTest.java 114 2011-07-13 09:08:48Z gerald.chen.hz@gmail.com $
 */
public class FileMonitorTest {

	@Test
	public void test() throws Exception {
		File file1 = FileUtil.getClasspathFile("work/files/file_one.txt");
		File file2 = FileUtil.getClasspathFile("work/files/file_anothoer.txt");
		
		FileMonitor monitor = FileMonitor.getInstance();
		TxtFileListener listener = new TxtFileListener();
		
		monitor.addFileChangeListener(listener, file1.getAbsolutePath(), 10 * 1000L);
		monitor.addFileChangeListener(listener, file2.getAbsolutePath(), 10 * 1000L);
		Thread.sleep(5 * 60 * 1000L);
	}
}
