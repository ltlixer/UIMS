package com.lixer.uims.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.ExperimentReport;

public interface ExperimentReportService {
	/**
	 * 根据id获取实验报告
	 * @param id
	 * @return
	 */
	public ExperimentReport getExperimentReportById(int id);
	/**
	 * 获取学生某个实验的实验报告
	 * @param userId
	 * @param experimentId
	 * @return
	 */
	public ExperimentReport geExperimentReport(int userId,int experimentId);
	/**
	 * 获取实验的所有实验报告
	 * @param teacherId
	 * @return
	 */
	public List<ExperimentReport> getExperimentReportsByExperimentId(int experimentId);
	
	/**
	 * 添加实验报告
	 * @param experimentReport
	 * @return
	 */
	public ExperimentReport addExperimentReport(ExperimentReport experimentReport,MultipartFile file);

	/**
	 * 下载实验报告
	 * @param experimentId
	 * @param response
	 */
	public void downloadExperimentReport(int experimentReportId,HttpServletResponse response);
	
	/**
	 * 删除实验报告
	 * @param experimentReportId
	 */
	public void deleteExperimentReport(int experimentReportId);
	
	/**
	 * 更新实验报告
	 * @param experimentReport
	 */
	public void updateExperimentReport(ExperimentReport experimentReport);
}
