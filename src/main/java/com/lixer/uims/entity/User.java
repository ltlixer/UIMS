package com.lixer.uims.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	
	//账号
	@Column(name = "username",unique=true,nullable=false,length=18)
	private long username;
	//密码
	@Column(name = "password",nullable=false,length=30)
	private String password;
	//姓名
	@Column(name = "realname",length=16,nullable=false)
	private String realname;
	//性别
	@Column(name = "sex",length=16)
	private String sex;
	//邮箱
	@Column(name = "email",length=30)
	private String email;
	//角色
	@Column(name = "role",length=30,nullable=false)
	private String role;
	public long getUsername() {
		return username;
	}
	public void setUsername(long username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
