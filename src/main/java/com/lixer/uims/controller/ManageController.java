package com.lixer.uims.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixer.uims.config.UserRole;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.UserService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	/**
	 * 加载添加老师的页面
	 * @return
	 */
	@RequestMapping("/add-teacher")
	public String linkAddTeacher(ModelMap model,HttpSession session,HttpServletRequest request) {
		logger.info("add teacher page");
		
		return "/user/teacher-add";
	}
	
	/**
	 * 添加老师
	 * @return
	 */
	@RequestMapping("/addTeacher")
	public String addTeacher(ModelMap model,HttpSession session,HttpServletRequest request) {
		logger.info("add teacher");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		
		User user = new User();
		user.setUsername(Long.parseLong(username));
		user.setPassword(password);
		user.setRealname(realname);
		user.setRole(UserRole.TEACHER);
		userService.userRegister(user);
		
		return "/user/teacher-add";
	}
	
}
