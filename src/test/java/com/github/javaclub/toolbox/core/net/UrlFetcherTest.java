/*
 * @(#)UrlFetcherTest.java	2010-5-8
 *
 * Copyright (c) 2010 by gerald. All Rights Reserved.
 */

package com.github.javaclub.toolbox.core.net;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javaclub.toolbox.Constants;
import com.github.javaclub.toolbox.core.Strings;
import com.github.javaclub.toolbox.util.FileUtil;

/**
 * desc
 *
 * @author <a href="mailto:gerald.chen@qq.com">Gerald Chen</a>
 * @version $Id: UrlFetcherTest.java,v 1.1 2010/06/24 16:51:00 gerald.chen Exp $
 */
public class UrlFetcherTest {
	
	static String DEST_FILE_PATH = Constants.WINDOWS ? "D:/temp/digfile" : "/temp/digfile";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileUtil.createDir(DEST_FILE_PATH);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(100 * 1000L);
	}

	@Test
	public void testFetch() throws Exception {
		String image = "http://www.apache.org/images/asf_logo_wide.gif";
		File file = UrlFetcher.fetch(image, DEST_FILE_PATH, false);
		System.out.println(file.getAbsolutePath());
		Thread.sleep(8000L);
	}

	@Test
	public void testMultiFetch() throws Exception {
		String[] urls = new String[] {
			"http://www.apache.org/images/asf_logo_wide.gif",
			"http://www.apache.org/images/asf_logo_wide.gif",
			"http://www.apache.org/images/asf_logo_wide.gif",
			"http://www.apache.org/images/asf_logo_wide.gif",
		};
		UrlFetcher.multiFetch(urls, DEST_FILE_PATH, false);
		// 设置断点，debug看效果
		System.out.println("kkk");
		Thread.sleep(15000L);
	}
	
	@Test
	public void testMultiFetch2() throws Exception  {
		/*String source = DownloadUtil.download("http://www.apache.org").getText();
		String regex = "/uploads/allimg/090504/.*gif";
		String[] links = Strings.multiFind(source, regex);
		for (int i = 0; i < links.length; i++) {
			links[i] = "http://cms.17ext.com" + links[i];
		}
		String dest = "D:/temp/digfile/ext";
		UrlFetcher.multiFetch(links, dest, false);*/
		// 设置断点，debug看效果
		System.out.println("kkk");
	}
	
	@Test
	public void testFetchBaiduHimage() throws Exception  {
		
		String from = "http://img.baidu.com/hi/";
		
		// babycat
		String  dest = Constants.WINDOWS ? "D:/temp/digfile/baidu" : "/temp/digfile/baidu";
		FileUtil.createDir(dest);
		
		String[] babycat = new String[100];
		for (int i = 0; i < 100; i++) {
			babycat[i] = from + "jx2/j_" + Strings.alignRight(String.valueOf(i), 4, '0') + ".gif";
		}
		UrlFetcher.multiFetch(babycat, dest, true);
		
		// 设置断点，debug看效果
		System.out.println("kkk");
		Thread.sleep(30000L);
	}


}
