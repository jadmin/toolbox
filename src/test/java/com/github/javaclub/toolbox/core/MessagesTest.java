/*
 * @(#)MessageFormatterTest.java	2017-3-4
 *
 * Copyright (c) 2017. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * MessageFormatterTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: MessageFormatterTest.java 2017-3-4 12:53:44 Exp $
 */
public class MessagesTest {

	@Test
	public void testFormat() {
		String target = MessageFormatter.format("Hi, {}, This is my mum, {}", "Tom", "CHINA");
		String expect = "Hi, Tom, This is my mum, CHINA";
		assertTrue(target.equals(expect));
	}
	

	@Test
	public void testFormat_1() {
		String target = MessageFormatter.format("Hi, Versy {}", "Nice");
		String expect = "Hi, Versy Nice";
		assertTrue(target.equals(expect));
	}
	
	@Test
	public void testFormat_2() {
		StringBuffer sbf = new StringBuffer("I am ");
		for (int i = 0; i < 100000; i++) {
			sbf.append("{} - ");
		}
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			list.add(Strings.random(10));
		}
		long start = System.currentTimeMillis();
		MessageFormatter.format(sbf.toString(), list.toArray(new String[0]));
		long end = System.currentTimeMillis();
		System.out.println("Time Cost => " + (end - start));
	}

}
