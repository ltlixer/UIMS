package com.lixer.uims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixer.uims.config.UserRole;
import com.lixer.uims.dao.CourseDAO;
import com.lixer.uims.dao.StudentCourseDAO;
import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.StudentCourse;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.CourseService;

@Service
@Transactional
public class CourseServiceIpml implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private StudentCourseDAO studentCourseDAO;

	
	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return courseDAO.getCourseById(id);
	}

	@Override
	public List<Course> getCourseByUser(User user) {
		// TODO Auto-generated method stub
		if(UserRole.STUDENT.equals(user.getRole())){
			//学生获取学习的课程
			List<StudentCourse> studentCourseList = studentCourseDAO.getStudentCourses(user.getUsername());
			if(studentCourseList!=null && !studentCourseList.isEmpty()){
				List<Course> courseList = new ArrayList<Course>();
				for(StudentCourse studentCourse:studentCourseList){
					courseList.add(studentCourse.getCourse());
				}
				return courseList;
			}else{
				return null;
			}
		}else if(UserRole.TEACHER.equals(user.getRole())){
			//老师获取自己的课程
			return courseDAO.getTeacherCourses(user.getUsername());
		}else if(UserRole.MANAGER.equals(user.getRole())){
			//管理员获取全部课程
			return courseDAO.getAllCourses();
		}else{
			return null;
		}
	}

	@Override
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
	}
	
	@Override
	public void deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		studentCourseDAO.deleteStudentCourseByCourseId(courseId);
		courseDAO.deleteCourseById(courseId);
	}

}
