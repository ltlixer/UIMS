package com.lixer.uims.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lixer.uims.dto.UserLoginInfo;
import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
    public UserLoginInfo userLogin(String username,String password);
    
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    public void userRegister(User user);
    
    /**
     * 判断用户名是否已经存在
     * @param username
     * @return
     */
    public boolean isUsernameExist(String username);
    
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);
    
    /**
     * 查询所有老师
     * @return
     */
    public List<User> getAllTeacher();
    
    /**
     * 通过excel给课程添加学生
     */
    public void addStudentForCourseByExcel(String savePath, MultipartFile file,Course course);
}
