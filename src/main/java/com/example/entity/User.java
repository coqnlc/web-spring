package com.example.entity;

import java.sql.Date;
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
	private String describe;
	private Date datetime;
	
	public User(String username, String password, int age, String describe) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.describe = describe;
		this.datetime = LCUtil.getSqlDateNow();
	}
	
	public String getDateTimeStr () {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null; 
		String str = date != null ? format.format(date) : "无";
		return str;
	}
}