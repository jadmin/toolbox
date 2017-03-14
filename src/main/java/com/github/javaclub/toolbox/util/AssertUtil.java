/*
 * @(#)AssertUtil.java	2011-7-21
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.util;

import java.util.List;

import com.github.javaclub.toolbox.core.Numbers;
import com.github.javaclub.toolbox.core.Strings;

/**
 * AssertUtil
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: AssertUtil.java 2011-7-21 18:24:28 Exp $
 */
public final class AssertUtil {
	
	private AssertUtil() {
	}

	public static void notNull(Object obj) {
		notNull(obj, "The input method parameter can't be null.");
	}
	
	public static void notNull(Object obj, String message) {
		if(obj == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notNull(String message, Object... objs) {
		if(null != objs && objs.length > 0) {
			for (int i = 0; i < objs.length; i++) {
				if(null == objs[i]) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}
	
	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notEmpty(String input, String message) {
		if(Strings.isEmpty(input)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void hasText(String text, String message) {
		if (!Strings.hasText(text)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void hasText(String text) {
		hasText(text, "[Assertion failed], this String argument must have text; it must not be null, empty, or blank");
	}
	
	public static void notNullZero(String message, List<Long> objs) {
		if(null != objs && objs.size() > 0) {
			for (Long val : objs) {
				if(null == val || 0 >= val) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}
	
	public static void shouldNumeric(String message, String... objs) {
		if(null != objs && objs.length > 0) {
			for (int i = 0; i < objs.length; i++) {
				if(null == objs[i] || !Numbers.isNumber(objs[i].toString())) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}
}
