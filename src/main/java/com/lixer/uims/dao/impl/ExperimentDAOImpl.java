package com.lixer.uims.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixer.uims.dao.ExperimentDAO;
import com.lixer.uims.entity.Experiment;

@Repository
public class ExperimentDAOImpl implements ExperimentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Experiment getExperimentById(int id) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From Experiment e Where e.id=:id");
		q.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Experiment> experimentList = q.list();
		if(!experimentList.isEmpty()&&experimentList!=null)
			return experimentList.get(0);
		else
			return null;
	}

	@Override
	public List<Experiment> getExperimentsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From Experiment e Where e.course.id=:courseid");
		q.setParameter("courseid", courseId);
		@SuppressWarnings("unchecked")
		List<Experiment> experimentList = q.list();
		return experimentList;
	}

	@Override
	public void addExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(experiment);
	}

	@Override
	public void deleteExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(experiment);
	}

	@Override
	public void deleteExperimentByExperimentId(int experimentId) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("delete Experiment e where e.id=:id");
		query.setInteger("id",experimentId);
		query.executeUpdate();
	}

}
