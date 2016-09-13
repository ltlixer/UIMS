package com.lixer.uims.dao;

import java.util.List;

import com.lixer.uims.entity.StudentCourse;

public interface StudentCourseDAO {
	
	/**
	 * 获取学生选课
	 * @param studentId
	 * @return
	 */
	public List<StudentCourse> getStudentCourses(long studentId);

	/**
	 * 添加学生选课
	 * @param studentCourse
	 */
	public void addStudentCourse(StudentCourse studentCourse);
	
	/**
	 * 根据选课记录id删除学生选课
	 * @param studentCourseId
	 */
	public void deleteStudentCourse(int studentCourseId);
	
	/**
	 * 删除某个课程的选课记录
	 * @param courseId
	 */
	public void deleteStudentCourseByCourseId(int courseId);
}
