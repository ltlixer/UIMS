package com.lixer.uims.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixer.uims.dto.UserLoginInfo;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 加载Login登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String userLogin(ModelMap model,HttpSession session,HttpServletRequest request) {
		logger.info("login page");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username!=null&&password!=null){
			UserLoginInfo userLoginInfo = userService.userLogin(username, password);
			if(userLoginInfo.getLoginStatus()==200){
				session.setAttribute("user", userLoginInfo.getUser());
				logger.info(userLoginInfo.getUser().getUsername()+" Login.");
				return "redirect:/";
			}
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String userLogout(ModelMap model,HttpSession session,HttpServletRequest request) {
		logger.info("logout page");
		Enumeration<String> em = session.getAttributeNames();
		while(em.hasMoreElements()){
			session.removeAttribute(em.nextElement().toString());
		}
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * 个人中心
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/user-profile")
	public String userProfile(ModelMap model,HttpSession session){
		User user = (User) session.getAttribute("user");
		logger.info(user.getRealname()+" enter user profile");
		model.addAttribute("user",user);
		return "user/user-profile";
	}
	
	/**
	 * 修改个人信息
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/user-profile/updateUserInfo")
	public String updateUserInfo(ModelMap model,HttpSession session){
		User user = (User) session.getAttribute("user");
		model.addAttribute("user",user);
		return "user/user-profile";
	}
}
