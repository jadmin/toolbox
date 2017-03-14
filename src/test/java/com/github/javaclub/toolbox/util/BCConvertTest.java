/*
 * @(#)BCConvertTest.java	2017年3月14日
 *
 * Copyright (c) 2017. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * BCConvertTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: BCConvertTest.java 2017年3月14日 上午9:37:23 Exp $
 */
public class BCConvertTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_全角转半角() {
		String s = "nihaoｈｋ　｜　　　ｎｉｈｅｈｅ　，。　７８　　７　８　０７＋＿－－--－－-￥";
		System.out.println(BCConvert.qj2bj(s));
	}

}
