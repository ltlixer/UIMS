package com.lixer.uims.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "experiment_report")
public class ExperimentReport {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	//实验报告名称
	@Column(name = "experiment_report_name",nullable=false)
	private String experimentReportName;
	//提交时间
	@Column(name = "submit_time",nullable=false)
	private long submitTime;
	//实验报告内容
	@Column(name = "experiment_report_content")
	private String experimentReportContent;
	//实验报告存放地址
	@Column(name = "experiment_report_url",nullable=false)
	private String experimentReportUrl;
	//状态，是否打分，老师已打分：true
	@Column(name = "experiment_report_status",nullable=false)
	private boolean status;
	//得分
	@Column(name = "experiment_report_score")
	private int score;
	// 所属实验作业
	@ManyToOne
	@JoinColumn(name = "experiment_id", referencedColumnName = "id", nullable = false)
	private Experiment experiment;
	// 所属学生
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExperimentReportName() {
		return experimentReportName;
	}
	public void setExperimentReportName(String experimentReportName) {
		this.experimentReportName = experimentReportName;
	}
	public long getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(long submitTime) {
		this.submitTime = submitTime;
	}
	public String getExperimentReportContent() {
		return experimentReportContent;
	}
	public void setExperimentReportContent(String experimentReportContent) {
		this.experimentReportContent = experimentReportContent;
	}
	public String getExperimentReportUrl() {
		return experimentReportUrl;
	}
	public void setExperimentReportUrl(String experimentReportUrl) {
		this.experimentReportUrl = experimentReportUrl;
	}
	public Experiment getExperiment() {
		return experiment;
	}
	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


}
