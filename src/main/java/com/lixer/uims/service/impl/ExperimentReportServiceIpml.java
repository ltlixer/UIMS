package com.lixer.uims.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lixer.uims.dao.ExperimentDAO;
import com.lixer.uims.dao.ExperimentReportDAO;
import com.lixer.uims.entity.ExperimentReport;
import com.lixer.uims.service.ExperimentReportService;
import com.lixer.uims.util.DeleteFile;
import com.lixer.uims.util.UploadDownloadFile;

@Service
@Transactional
public class ExperimentReportServiceIpml implements ExperimentReportService {
	
	@Autowired
	private ExperimentDAO experimentDAO;
	@Autowired
	private ExperimentReportDAO experimentReportDAO;

	
	@Override
	public ExperimentReport getExperimentReportById(int id) {
		// TODO Auto-generated method stub
		return experimentReportDAO.getExperimentReportById(id);
	}

	@Override
	public ExperimentReport geExperimentReport(int userId,int experimentId){
		return experimentReportDAO.geExperimentReport(userId, experimentId);
	}

	@Override
	public List<ExperimentReport> getExperimentReportsByExperimentId(int experimentId) {
		// TODO Auto-generated method stub
		return experimentReportDAO.getExperimentReportsByExperimentId(experimentId);
	}

	@Override
	public ExperimentReport addExperimentReport(ExperimentReport experimentReport,MultipartFile file) {
		// TODO Auto-generated method stub
		String filepath = experimentReport.getExperimentReportUrl();
		String fileName = UploadDownloadFile.uploadfile(file, filepath);
		experimentReport.setExperimentReportUrl(filepath+"\\"+fileName);
		experimentReportDAO.addExperimentReport(experimentReport);
		return experimentReport;
	}

	@Override
	public void downloadExperimentReport(int experimentReportId, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ExperimentReport experimentReport = experimentReportDAO.getExperimentReportById(experimentReportId);
	
		try {
			UploadDownloadFile.download(response,experimentReport.getExperimentReportUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteExperimentReport(int experimentReportId) {
		// TODO Auto-generated method stub
		ExperimentReport experimentReport = experimentReportDAO.getExperimentReportById(experimentReportId);
		DeleteFile.deleteFile(experimentReport.getExperimentReportUrl());
		experimentReportDAO.deleteExperimentReport(experimentReportId);
	}

	@Override
	public void updateExperimentReport(ExperimentReport experimentReport) {
		// TODO Auto-generated method stub
		experimentReportDAO.updateExperimentReport(experimentReport);
	}

}
