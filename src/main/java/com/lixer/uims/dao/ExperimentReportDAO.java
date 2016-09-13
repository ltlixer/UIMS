package com.lixer.uims.dao;

import java.util.List;

import com.lixer.uims.entity.ExperimentReport;

public interface ExperimentReportDAO {
	
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
	 */
	public void addExperimentReport(ExperimentReport experimentReport);
	/**
	 * 删除某个实验报告
	 * @param experimentId
	 */
	public void deleteExperimentReport(int experimentReportId);
	/**
	 * 更新实验报告
	 * @param experimentReport
	 */
	public void updateExperimentReport(ExperimentReport experimentReport);
	
}
