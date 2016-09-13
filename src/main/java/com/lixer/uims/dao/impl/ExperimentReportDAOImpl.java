package com.lixer.uims.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixer.uims.dao.ExperimentReportDAO;
import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.ExperimentReport;

@Repository
public class ExperimentReportDAOImpl implements ExperimentReportDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public ExperimentReport getExperimentReportById(int id) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From ExperimentReport er Where er.id=:id");
		q.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<ExperimentReport> experimentReportList = q.list();
		if(!experimentReportList.isEmpty()&&experimentReportList!=null)
			return experimentReportList.get(0);
		else
			return null;
	}

	@Override
	public ExperimentReport geExperimentReport(int userId,int experimentId){
		Query q= sessionFactory.getCurrentSession().createQuery("From ExperimentReport er Where er.user=:userId and er.experiment.id=:experimentId");
		q.setInteger("userId", userId);
		q.setInteger("experimentId", experimentId);
		@SuppressWarnings("unchecked")
		List<ExperimentReport> experimentReportList = q.list();
		if(!experimentReportList.isEmpty()&&experimentReportList!=null)
			return experimentReportList.get(0);
		else
			return null;
	}
	
	@Override
	public List<ExperimentReport> getExperimentReportsByExperimentId(int experimentId) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From ExperimentReport er Where er.experiment.id=:experimentId");
		q.setParameter("experimentId", experimentId);
		@SuppressWarnings("unchecked")
		List<ExperimentReport> experimentReportList = q.list();
		return experimentReportList;
	}

	@Override
	public void addExperimentReport(ExperimentReport experimentReport) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(experimentReport);
	}

	@Override
	public void deleteExperimentReport(int experimentReportId) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("delete ExperimentReport er where er.id=:id");
		query.setInteger("id",experimentReportId);
		query.executeUpdate();
	}

	@Override
	public void updateExperimentReport(ExperimentReport experimentReport) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(experimentReport);
		sessionFactory.getCurrentSession().flush();
	}

}
