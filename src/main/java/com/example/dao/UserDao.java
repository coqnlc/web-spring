package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

/**
 * 用户持久层
 * @author 李超
 *
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(User user) {
		String sql = "insert into user set(username, password, age, describe, datetime) values(?, ?, ?, ?, ?)";
		int count = jdbc.update(sql, user.getUsername(), user.getPassword(), user.getAge(), user.getDescribe(), user.getDatetime());
		return count;
	} 
	
	public int delete(int id) {
		return jdbc.update("delete from user where id = " + id);
	}
	
	public int update(User user) {
		String sql = "update user set(username, password, age, describe, datetime) values(? , ?, ?, ?, ?)";
		int count = jdbc.update(sql, user.getUsername(), user.getPassword(), user.getAge(), user.getDescribe(), user.getDatetime());
		return count;
	}
	
	public User queryOne(int id) {
		return jdbc.queryForObject("select * from user where id = " + id, User.class);
	}
	
	public List<User> queryAll() {
		return jdbc.queryForList("select * from user", User.class);
	}
}
