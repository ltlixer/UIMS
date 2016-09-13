package com.lixer.uims.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	
	//班级名称
	@Column(name = "class_name",nullable=false,length=18)
	private String className;
	//年级
	@Column(name = "grade",nullable=false,length=30)
	private String grade;
	//信息
	@Column(name = "class_info")
	private String info;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
