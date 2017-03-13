/*
 * @(#)RFBPTest.java	2011-9-8
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core.net.rfbp;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javaclub.toolbox.Constants;
import com.github.javaclub.toolbox.util.FileUtil;

/**
 * RFBPTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: RFBPTest.java 2011-9-8 下午03:17:53 Exp $
 */
public class RFBPTest {
	
	static String DEST_FILE_PATH = Constants.WINDOWS ? "D:/temp/digfile/download" : "/temp/digfile/download";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileUtil.createDir(DEST_FILE_PATH);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(100 * 1000L);
	}

	@Test
	public void test_0() throws Exception {
		String url = "http://downloads.jianshu.io/apps/haruki/jianShu-release-2.1.3-JianShu.apk";

		String name = "app.apk";
		File file = new File(DEST_FILE_PATH + "/" + name);
		if(file.exists()) {
			file.delete();
		}
		
		new RFBP(url, DEST_FILE_PATH, name).start();
	}
	
	@Test
	public void test_download_tomcat() throws Exception {
		/*String url = "http://labs.renren.com/apache-mirror/tomcat/tomcat-7/v7.0.21/bin/apache-tomcat-7.0.21.zip";
		String path = "D:/temp/fetch";
		String name = "tomcat_v7.0.21.zip";
		new RFBP(url, path, name).start();*/
	}
	
	@Test
	public void test_download_qq() throws Exception {
		/*String url = "http://dl_dir.qq.com/qqfile/qq/QQ2011/QQ2011Beta4.exe";
		String path = "D:/temp/fetch";
		String name = "QQ2011Beta4.exe";
		new RFBP(url, path, name).start();*/
	}

}
