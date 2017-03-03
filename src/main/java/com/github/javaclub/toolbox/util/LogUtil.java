/*
 * @(#)LogUtil.java	2011-2-23
 *
 * Copyright (c) 2011. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.github.javaclub.toolbox.Constants;

import org.springframework.util.StringUtils;

/**
 * 日志记录工具类
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: LogUtil.java 80 2011-06-29 07:13:50Z gerald.chen.hz@gmail.com $
 */
public class LogUtil {
	
	private static String timeFormat = "yyyy/MM/dd HH:mm:ss";
	
	private static String logPath = Constants.USER_HOME_DIR;
	
	/** 默认每天一个日志文件 */
	private static boolean singleFile = false;

	/**
	 * 直接记录某段文本信息
	 *
	 * @param 要记录的信息
	 */
	public static void write(String message) {
		File logFile = ensureLogFile();
		if(null == logFile) return;
		String timePrefix = DateUtil.getFormat(new Date(), timeFormat);
		FileUtil.writeText(logFile, timePrefix + " - " + message, true);
	}

	/**
	 * 记录带有格式的混合文本信息
	 *
	 * @param message 带有格式的混合信息内容
	 * @param arr 匹配格式的内容
	 */
	public static void write(String message, Object[] arr) {
		File logFile = ensureLogFile();
		if(null == logFile) return;
		String info = MessageUtil.format(message, arr);
		String timePrefix = DateUtil.getFormat(new Date(), timeFormat);
		FileUtil.writeText(logFile, timePrefix + " - " + info, true);
	}
	
	/**
	 * Create the target log file.
	 *
	 */
	protected static File ensureLogFile() {
		String filepath = StringUtils.cleanPath(logPath + File.separator + "log.log");
		if (!singleFile) {
			filepath = filepath.substring(0, filepath.lastIndexOf(".")) + "_"
					     + DateUtil.currentDate()
					     + filepath.substring(filepath.lastIndexOf("."));
		}
		try {
			return FileUtil.createFile(filepath);
		} catch (IOException e) {
			throw new RuntimeException("IOException happened when createFile[" + filepath + "]", e);
		}
	}

	public void setTimeFormat(String timeFormat) {
		LogUtil.timeFormat = timeFormat;
	}

	public void setLogPath(String logPath) {
		LogUtil.logPath = logPath;
	}

	public void setSingleFile(boolean singleFile) {
		LogUtil.singleFile = singleFile;
	}
	
}
