package com.lixer.uims.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixer.uims.dao.CourseDAO;
import com.lixer.uims.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From Course c Where c.id=:id");
		q.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Course> courseList = q.list();
		if(!courseList.isEmpty()&&courseList!=null)
			return courseList.get(0);
		else
			return null;
	}

	@Override
	public List<Course> getTeacherCourses(long teacherId) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From Course c Where c.teacher.username=:teacherid");
		q.setParameter("teacherid", teacherId);
		@SuppressWarnings("unchecked")
		List<Course> courseList = q.list();
		return courseList;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From Course");
		@SuppressWarnings("unchecked")
		List<Course> courseList = q.list();
		return courseList;
	}

	@Override
	public void addCourse(Course course){
		sessionFactory.getCurrentSession().save(course);
	}
	
	@Override
	public void deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("delete Course c where c.id=:id");
		query.setInteger("id",courseId);
		query.executeUpdate();
	}

}
