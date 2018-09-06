package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	public int insert(User user) {
		return service.insert(user);
	}
	
	public int delete(int id) {
		return service.delete(id);
	}
	
	public int update(User user) {
		return service.udpate(user);
	}
	
	public User queryOne(int id) {
		return service.queryOne(id);
	}
	
	@RequestMapping("/list")
	public String queryAll(ModelMap model) {
		List<User> users = service.queryAll();
		model.addAttribute("userList", users);
		return "user/list";
	}
	
}
