/*
 * @(#)StringsTest.java	2017年4月25日
 *
 * Copyright (c) 2017. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core;

import org.junit.Test;

/**
 * StringsTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: StringsTest.java 2017年4月25日 11:21:36 Exp $
 */
public class StringsTest {

	@Test
	public void testMapJson() {
		String json = Strings.createMapJson("name", "XiaoMing").entry("sex", "男")
							.entry("job", "enginner")
							.entry("wifi", "ooi")
							.entry("level", "5")
							.toString();
		System.out.println(json);
	}
}
