package com.lixer.uims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.CourseService;
import com.lixer.uims.service.UserService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	/**
	 * 加载课程列表
	 * @return
	 */
	@RequestMapping("/list")
	public String userLogin(ModelMap model,HttpSession session,HttpServletRequest request) {
		logger.info("course list page");
		User user = (User) session.getAttribute("user");
		List<Course> courseList = courseService.getCourseByUser(user);
		model.addAttribute("courseList",courseList);
		return "course/course-list";
	}
	
	/**
	 * 跳转到添加课程界面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView linkToAddCourse( ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course add page");
		List<User> teacherList = userService.getAllTeacher();
		model.addAttribute("teacherList",teacherList);
		return new ModelAndView("course/course-add");
	}

	/**
	 * 添加课程
	 * 
	 * @return
	 */
	@RequestMapping("/addCourse")
	public String addExperiment(@RequestParam MultipartFile file,ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course add service");
		String courseName = request.getParameter("courseName");
		String teachername = request.getParameter("teacher");
		String info = request.getParameter("info");
		String savePath = request.getSession().getServletContext().getRealPath("/temp/");		
		
		User teacher = userService.getUserByUsername(teachername);
		Course course = new Course();
		course.setCourseName(courseName);
		course.setInfo(info);
		course.setTeacher(teacher);
		userService.addStudentForCourseByExcel(savePath, file, course);
		
		return "redirect:/course/list/";
	}

	/**
	 * 删除课程
	 * 
	 * @return
	 */
	@RequestMapping("/delete/{courseId}")
	public String deleteExperiment(@PathVariable("courseId") int courseId,
			@ModelAttribute("experiment") Experiment experiment, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course delete page");
		courseService.deleteCourseById(courseId);
		return "redirect:/course/list/";
	}
	
	
}
