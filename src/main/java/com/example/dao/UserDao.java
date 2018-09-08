package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.util.LCUtil;

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
		String sql = "insert into `user`(`username`, `password`, `age`, `sex`, `city`, `hobby`, `describe`, `datetime`) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = new Object[] { user.getUsername(), user.getPassword(), user.getAge(), user.getSex(), user.getCity(), user.getHobby(), user.getDescribe(), user.getDatetime() };
		return jdbc.update(sql, args);
	} 
	
	public int delete(int id) {
		return jdbc.update("delete from user where id = " + id);
	}
	
	public int update(User user) {
		String sql = "update `user` set `username` = ?, `password` = ?, `age` = ?, `sex` = ?, `city` = ?, `hobby` = ? , `describe` = ?, `datetime` = ? where `id` = ?";
		Object[] args = new Object[] { user.getUsername(), user.getPassword(), user.getAge(), user.getSex(), user.getCity(), user.getHobby(), user.getDescribe(), user.getDatetime(), user.getId() };
		return jdbc.update(sql, args);
	}
	
	public User queryOne(int id) {
		return jdbc.queryForObject("select * from user where id = " + id, new UserRowMapper());
	}
	
	public List<User> queryAll() {
		return jdbc.query("select * from user", new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
			user.setCity(rs.getInt("city"));
			user.setHobby(rs.getString("hobby"));
			user.setDescribe(rs.getString("describe"));
			user.setDatetime(rs.getDate("datetime"));
			return user;
		}
	}
	
}
