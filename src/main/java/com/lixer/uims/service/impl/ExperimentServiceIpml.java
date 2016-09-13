package com.lixer.uims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixer.uims.dao.ExperimentDAO;
import com.lixer.uims.dao.ExperimentReportDAO;
import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.ExperimentReport;
import com.lixer.uims.service.ExperimentService;
import com.lixer.uims.util.DeleteFile;

@Service
@Transactional
public class ExperimentServiceIpml implements ExperimentService {
	
	@Autowired
	private ExperimentDAO experimentDAO;
	@Autowired
	private ExperimentReportDAO experimentReportDAO;

	
	@Override
	public Experiment getExperimentById(int id) {
		// TODO Auto-generated method stub
		return experimentDAO.getExperimentById(id);
	}

	@Override
	public List<Experiment> getExperimentsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return experimentDAO.getExperimentsByCourseId(courseId);
	}

	@Override
	public Experiment addExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		experimentDAO.addExperiment(experiment);
		return experiment;
	}

	@Override
	public void deleteExperimentByExperimentId(int experimentId) {
		// TODO Auto-generated method stub
		List<ExperimentReport> experimentReportList = experimentReportDAO.getExperimentReportsByExperimentId(experimentId);
		if(experimentReportList!=null && !experimentReportList.isEmpty()){
			for(ExperimentReport er:experimentReportList){
				DeleteFile.deleteFile(er.getExperimentReportUrl());
				experimentReportDAO.deleteExperimentReport(er.getId());
			}
		}
		experimentDAO.deleteExperimentByExperimentId(experimentId);
	}

}
