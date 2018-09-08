package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.LCUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/updatePage")
	public String updatePage(int id, ModelMap model) {
		User user = service.queryOne(id);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(User user) {
		ModelAndView mv = new ModelAndView();
		int result = service.insert(user);
		if (result > 0) {
			mv.setViewName("redirect:/user/queryList");
		} else {
			mv.setViewName("error");
			mv.addObject("errorInfo", "插入失败！");
		}
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int id) {
		ModelAndView mv = new ModelAndView();
		int result = service.delete(id);
		if (result > 0) {
			mv.setViewName("redirect:/user/queryList");
		} else {
			mv.setViewName("error");
			mv.addObject("errorInfo", "删除失败！");
		}
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(User user) {
		ModelAndView mv = new ModelAndView();
		int result = service.update(user);
		if (result > 0) {
			mv.setViewName("redirect:/user/queryList");
		} else {
			mv.setViewName("error");
			mv.addObject("errorInfo", "更新失败！");
		}
		return mv;
	}
	
	@RequestMapping("/queryOne")
	public ModelAndView queryOne(int id) {
		ModelAndView mv = new ModelAndView("user/query");
		User user = service.queryOne(id);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/queryList")
	public ModelAndView queryAll() {
		ModelAndView mv = new ModelAndView("user/list");
		List<User> userList = service.queryAll();
		mv.addObject("userList", userList);
		return mv;
	}
	
}
