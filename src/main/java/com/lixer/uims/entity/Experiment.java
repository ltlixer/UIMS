package com.lixer.uims.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "experiment")
public class Experiment {

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	
	//实验名称
	@Column(name = "experiment_name",nullable=false,length=18)
	private String experimentName;
	//开始时间
	@Column(name = "start_time",nullable=false,length=18)
	private String startTime;
	//结束时间
	@Column(name = "end_time",nullable=false,length=18)
	private String endTime;
	//实验内容
	@Column(name = "experiment_content",nullable=false,length=30)
	private String experimentContent;
	// 所属课程
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
	private Course course;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExperimentName() {
		return experimentName;
	}
	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getExperimentContent() {
		return experimentContent;
	}
	public void setExperimentContent(String experimentContent) {
		this.experimentContent = experimentContent;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
