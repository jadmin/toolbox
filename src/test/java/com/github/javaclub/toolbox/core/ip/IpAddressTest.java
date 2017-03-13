/*
 * @(#)IpAddressTest.java	2017年3月13日
 *
 * Copyright (c) 2017. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core.ip;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javaclub.toolbox.util.SpringContextUtil;

/**
 * IpAddressTest
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: IpAddressTest.java 2017年3月13日 下午2:16:36 Exp $
 */
public class IpAddressTest {
	
	static ApplicationContext context;
	
	static IPAddress ipAddress;
	
	@Before
	public void init() throws Exception {
		context = new ClassPathXmlApplicationContext("conf/spring/utility.context.xml");
		ipAddress = SpringContextUtil.getBean("ipAddress");
	}
	
	@After
	public void destroy() {
		if (context != null) {
			((AbstractApplicationContext) context).destroy();
		}
	}
	

	@Test
	public void testIp() {
		// String ips = "115.192.18.73";
		String ips = "159.226.125.118";
		
		String country = ipAddress.getCountry(ips);
		System.out.println(country);
		
		String area = ipAddress.getArea(ips);
		System.out.println(area);
	}

}
