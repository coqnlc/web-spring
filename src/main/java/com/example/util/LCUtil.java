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
	
	/**
	 * 转换数组为字符串
	 * @param arr
	 * @return
	 */
	public static String Arr2Str(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i< arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 转化字符串为数组
	 * @param arr
	 * @return
	 */
	public static String[] Str2Arr(String arr) {
		String[] strArr = arr.split(",");
		return strArr;
	}
	
}
