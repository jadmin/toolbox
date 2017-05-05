/*
 * @(#)ResultDO.java	2013-11-29
 *
 * Copyright (c) 2013. All Rights Reserved.
 *
 */

package com.github.javaclub.toolbox.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ResultDO 简单结果对象的封装
 *
 * @author <a href="mailto:gerald.chen.hz@gmail.com">Gerald Chen</a>
 * @version $Id: ResultDO.java 2013-11-29 10:43:04 Exp $
 */
public class ResultDO<T> implements Serializable {

	private static final long serialVersionUID = 5146487207349338705L;
	
	/**
	 * 是否执行成功 
	 */
	private boolean success = false;
	
	/**
	 * 返回给请求端的唯一识别码，1-成功，0-失败  
	 */
	private int resultCode;
	
	/**
	 * 具体的提示信息 
	 */
	private String message;
	
	/**
	 * 主要返回数据对象
	 */
	private T result;
	
	/**
     * 额外返回的结果集 
     */
    private Map<String, Object> extraResultMap = new HashMap<String, Object>();
    
    public Map<String, Object> getExtraResultMap() {
    	return extraResultMap;
    }
    
    public void addExtraResult(String key, Object extraResult) {
    	extraResultMap.put(key, extraResult);
    }
    
    public Object getExtraResult(String key) {
    	return extraResultMap.get(key);
    }

	public ResultDO() {
	}

	public ResultDO(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T value) {
		this.result = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
