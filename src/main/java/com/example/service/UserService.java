package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class UserService {
 
	@Autowired
	private UserDao dao;
	
	public int insert(User user) {
		return dao.insert(user);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public int update(User user) {
		return dao.update(user);
	}
	
	public User queryOne(int id) {
		return dao.queryOne(id);
	}
	
	public List<User> queryAll() {
		return dao.queryAll();
	}
	
}
