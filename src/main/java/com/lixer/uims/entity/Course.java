package com.lixer.uims.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	//课程名称
	@Column(name = "course_name",unique=true,nullable=false,length=18)
	private String courseName;
	//信息
	@Column(name = "course_info")
	private String info;
	// 所属老师
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
	private User teacher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

}
