package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
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
	
	@RequestMapping("/")
	public String queryAll(ModelMap model) {
		//List<User> users = service.queryAll();
		//List<User> users = new ArrayList<User>();
		//users.add(new User("1", "2", 3, "4"));
		//users.add(new User("11", "22", 33, "44"));
		
		model.addAttribute("test", "XXOO");
		//model.addAttribute("userList", users);
		return "index";
	}
	
}
