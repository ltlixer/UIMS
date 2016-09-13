package com.lixer.uims.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixer.uims.dao.CourseDAO;
import com.lixer.uims.dao.StudentCourseDAO;
import com.lixer.uims.dao.UserDAO;
import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.StudentCourse;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.CourseService;

@Repository
public class StudentCourseDAOImpl implements StudentCourseDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<StudentCourse> getStudentCourses(long studentId) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From StudentCourse sc Where sc.student.username=:studentid");
		q.setParameter("studentid", studentId);
		@SuppressWarnings("unchecked")
		List<StudentCourse> studentCourseList = q.list();
		return studentCourseList;
	}


	@Override
	public void addStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentCourse);
	}


	@Override
	public void deleteStudentCourse(int studentCourseId) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("delete StudentCourse sc where sc.id=:id");
		query.setInteger("id",studentCourseId);
		query.executeUpdate();
	}


	@Override
	public void deleteStudentCourseByCourseId(int courseId) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("delete StudentCourse sc where sc.course.id=:id");
		query.setInteger("id",courseId);
		query.executeUpdate();
	}
	
}
