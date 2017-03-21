/*
 * @(#)Systems.java	2017-03-22
 *
 * Copyright (c) 2017. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.core;

import com.github.javaclub.toolbox.Constants;

/**
 *  Utils for System.
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: Systems.java 2017-03-22 2017-03-22 00:17:12 Exp $
 */
public final class Systems {
	
	private  Systems() {
	}
	
	/**
	 * Log messages on system console.
	 *
	 * @param format message pattern format
	 * @param params parameter array
	 */
	public static void out(String format, Object ... params) {
		String msg = Messages.format(format, params);
		System.out.println(msg);
	}
	
	/**
	 * Get current machine's cup core num.
	 *
	 * @return
	 */
	public static int cupNum() {
		return Constants.CPU_CORES;
	}

	public static void main(String[] args) {
		Systems.out("cpu_num={}", cupNum());
	}

}
