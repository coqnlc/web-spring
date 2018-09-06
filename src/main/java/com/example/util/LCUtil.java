package com.example.util;

/**
 * 基础工具类
 * @author 李超
 *
 */
public class LCUtil {
	
	/**
	 * 获得数据库Date的当前时间
	 * @return
	 */
	public static java.sql.Date getSqlDateNow() {
		return new java.sql.Date(new java.util.Date().getTime());
	}
	
	/**
	 * 打印日志
	 * @param str
	 */
	public static void Log(String str) {
		System.out.println(str);
	}
	
}
