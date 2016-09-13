package com.lixer.uims.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	//课程
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
	private Course course;
	//学生
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
	private User student;
	//成绩
	@Column(name = "grade", columnDefinition="int default -1")
	private int grade;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
