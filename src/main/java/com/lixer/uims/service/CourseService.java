package com.lixer.uims.service;

import java.util.List;

import com.lixer.uims.entity.Class;
import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.User;

public interface CourseService {
	
	/**
	 * 根据id获取课程
	 * @param id
	 * @return
	 */
	public Course getCourseById(int id);
	/**
	 * 获取某个用户的课程，老师教的课程或学生学的课程
	 * @param videoType
	 * @return
	 */
	public List<Course> getCourseByUser(User user);
	
	/**
	 * 添加课程
	 * @param course
	 */
	public void addCourse(Course course);
	
	/**
	 * 删除课程
	 * @param courseId
	 */
	public void deleteCourseById(int courseId);
	
}
