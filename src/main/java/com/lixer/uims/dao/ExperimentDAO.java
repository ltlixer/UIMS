package com.lixer.uims.dao;

import java.util.List;

import com.lixer.uims.entity.Experiment;

public interface ExperimentDAO {
	
	/**
	 * 根据id获取实验
	 * @param id
	 * @return
	 */
	public Experiment getExperimentById(int id);
	/**
	 * 获取课程的所有实验
	 * @param teacherId
	 * @return
	 */
	public List<Experiment> getExperimentsByCourseId(int courseId);
	
	/**
	 * 添加实验
	 * @param experiment
	 */
	public void addExperiment(Experiment experiment);
	/**
	 * 删除实验
	 * @param experiment
	 */
	public void deleteExperiment(Experiment experiment);
	public void deleteExperimentByExperimentId(int experimentId);

}
