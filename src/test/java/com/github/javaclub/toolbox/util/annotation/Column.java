/*
 * @(#)Colum.java	2010-4-21
 *
 * Copyright (c) 2010 by gerald. All Rights Reserved.
 */

package com.github.javaclub.toolbox.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 声明一个 Java 字段是否有对应的数据库字段
 * <p>
 * 如果数据库字段名同 JAVA 字段名不一样，通过这个注解可以进行特殊标注:
 * 
 * <pre>
 * &#064;Column(&quot;数据库字段名&quot;)
 * </pre>
 * 
 * <b style=color:red>需要说明的是：</b>
 * <ul>
 * <li>
 * 如果你的 POJO <u><b>没有任何一个字段</b></u> 声明了这个注解，那么所有的 Java 字段都会被认为是数据库字段。
 * </ul>
 *
 * @author <a href="mailto:gerald.chen@qq.com">Gerald Chen</a>
 * @version $Id: Column.java 116 2011-07-13 09:09:34Z gerald.chen.hz@gmail.com $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
	
	String value() default "";
}
