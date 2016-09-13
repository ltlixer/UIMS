package com.lixer.uims.dao;

import java.util.List;

import com.lixer.uims.entity.Course;

public interface CourseDAO {
	
	/**
	 * 根据id获取课程
	 * @param id
	 * @return
	 */
	public Course getCourseById(int id);
	/**
	 * 获取老师授课课程
	 * @param teacherId
	 * @return
	 */
	public List<Course> getTeacherCourses(long teacherId);
	
	/**
	 * 获取所有的课程
	 * @return
	 */
	public List<Course> getAllCourses();
	
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
