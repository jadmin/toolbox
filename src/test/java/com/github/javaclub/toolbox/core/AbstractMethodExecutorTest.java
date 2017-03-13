/*
 * @(#)AbstractMethodExecutorTest.java	2011-1-13
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.github.javaclub.toolbox.Constants;
import com.github.javaclub.toolbox.core.AbstractMethodExecutor;
import com.github.javaclub.toolbox.util.FileUtil;
import com.github.javaclub.toolbox.util.UuidUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * desc
 *
 * @author <a href="mailto:gerald.chen@qq.com">Gerald Chen</a>
 * @version $Id: AbstractMethodExecutorTest.java 172 2011-07-23 10:42:48Z gerald.chen.hz@gmail.com $
 */
public class AbstractMethodExecutorTest {
	
	static String DEST_FILE_PATH = Constants.WINDOWS ? "D:/temp/data/" : "/temp/data/";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileUtil.createDir(DEST_FILE_PATH);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(10 * 1000L);
	}

	
	@Test
	public void testDemo() {
		File file = new File(DEST_FILE_PATH);
		CreateFileTask download = new CreateFileTask(file, 80);
		download.doTask();
		System.out.println(download.getResult());
	}

}

class CreateFileTask extends AbstractMethodExecutor<File, MessageResult> {
	
	static String DEST_FILE_PATH = Constants.WINDOWS ? "D:/temp/data/" : "/temp/data/";

	public CreateFileTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateFileTask(int maxTimes) {
		super(maxTimes);
		// TODO Auto-generated constructor stub
	}

	public CreateFileTask(File param, int maxTimes) {
		super(param, maxTimes);
	}

	public void execute() {
		try {
			FileUtil.createFile(DEST_FILE_PATH + UuidUtil.newUUID() + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public MessageResult failure() {
		return new MessageResult("=====执行失败=====");
	}

	public boolean isExpected() {
		File dir = this.getParam();
		File[] files = dir.listFiles();
		return files.length >= 1000;
	}

	public MessageResult success() {
		return new MessageResult("=====执行成功=====");
	}
	
}

class MessageResult implements Serializable {

	/** desc */
	private static final long serialVersionUID = 7869523839721888134L;
	
	private String message;
	
	public MessageResult() {
		super();
	}

	public MessageResult(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return "MessageResult [message=" + message + "]";
	}
	
}
