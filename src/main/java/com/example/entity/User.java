package com.example.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.util.LCUtil;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 用户实体
 * @author 李超
 *
 */
@Data
@NoArgsConstructor
public class User {
	@NonNull
	private Integer id;
	@NonNull
	private String username;
	@NonNull
	private String password;
	private Integer age;
	private int sex;
	private int city;
	private String hobby;
	private String describe;
	private Date datetime;
	
	public User(String username, String password, int age, int sex, int city, String hobby, String describe, String datetime) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.city = city;
		this.hobby = hobby;
		this.describe = describe;
		setDateTimeStr(datetime);
	}
	
	/**
	 * 设置字符串到日期
	 * @param datetime
	 */
	public void setDateTimeStr(String datetime) {
		if (datetime == null || datetime.equals("")) {
			this.datetime = null;
			return;
		}
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(datetime);
			this.datetime = new Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得格式化后的日期=yyyy-MM-dd
	 * @return
	 */
	public String getDateTimeStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = getDatetime();
		String str = date != null ? format.format(date) : "无";
		return str;
	}
	
	/**
	 * 获得格式化后的性别
	 * @return
	 */
	public String getSexStr() {
		return sex == 0 ? "男" : "女";
	}
	
	/**
	 * 获得格式化后的城市
	 * @return
	 */
	public String getCityStr() {
		switch (city) {
		case 0: return "北京";
		case 1: return "上海";
		case 2: return "广州";
		default:return "未知";
		}
	}
	
	/**
	 * 获得格式化后的爱好
	 * @return
	 */
	public String getHobbyStr() {
		StringBuilder sb = new StringBuilder();
		String[] hobbys = LCUtil.Str2Arr(hobby);
		for (String s : hobbys) {
			if (s.equals("0")) {
				sb.append("运动");
			} else if (s.equals("1")) {
				sb.append("音乐");
			} else if (s.equals("2")) {
				sb.append("睡觉");
			} else {
				sb.append("未知");
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
	/**
	 * 获得爱好数组
	 * @return
	 */
	public String[] getHobbyArr() {
		return LCUtil.Str2Arr(hobby);
	}
}