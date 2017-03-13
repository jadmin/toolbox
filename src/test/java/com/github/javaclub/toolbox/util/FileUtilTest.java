/*
 * @(#)FileUtilTest.java	2011-7-18
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javaclub.toolbox.beans.User;



/**
 * FileUtilTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: FileUtilTest.java 1619 2012-03-11 15:34:04Z gerald.chen.hz@gmail.com $
 */
public class FileUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void testGetClassFile() {
		User user = new User("Kate", "123456", "Student");
		
		String str = FileUtil.getClassesDirectory(user);
		System.out.println(str);
		
		str = FileUtil.getClassPath();
		System.out.println("\nclasspath=" + str);
		
		File file = FileUtil.getClassesFile(user);
		System.out.println("\nclassfiles=" + file);
	}
	
	@Test
	public void testStream() throws IOException {
		InputStream stream = FileUtil.stream("THis istext");
		
		String txt = FileUtil.readAsString(stream);
		System.out.println(txt);
	}
	
	@Test
	public void testGetClasspathFile() {
		File file = FileUtil.getClasspathFile("conf/props/test.properties");
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
	}
	
	
}

class CodeName {
	
	
	public CodeName() {
		super();
	}

	private int code;
	
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
