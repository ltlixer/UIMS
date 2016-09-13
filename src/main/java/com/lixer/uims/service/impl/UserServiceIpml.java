package com.lixer.uims.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lixer.uims.config.UserRole;
import com.lixer.uims.dao.CourseDAO;
import com.lixer.uims.dao.StudentCourseDAO;
import com.lixer.uims.dao.UserDAO;
import com.lixer.uims.dto.UserLoginInfo;
import com.lixer.uims.entity.Course;
import com.lixer.uims.entity.StudentCourse;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.UserService;
import com.lixer.uims.util.DeleteFile;
import com.lixer.uims.util.StudentExcel;
import com.lixer.uims.util.UploadDownloadFile;

@Service
@Transactional
public class UserServiceIpml implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private StudentCourseDAO studentCourseDAO;

	@Override
	public UserLoginInfo userLogin(String username, String password) {
		// TODO Auto-generated method stub
		List<User> userList = userDAO.getUser(username, password);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		if (userList != null&&userList.size()!=0) {
			userLoginInfo.setLoginStatus(200);
			userLoginInfo.setLoginInfo("登录成功");
			userLoginInfo.setUser(userList.get(0));
			return userLoginInfo;
		}else{
			userLoginInfo.setLoginStatus(500);
			userLoginInfo.setLoginInfo("登用户名或密码错误");
			userLoginInfo.setUser(null);
			return userLoginInfo;
		}
	}

	@Override
	public void userRegister(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
	}

	@Override
	public boolean isUsernameExist(String username) {
		// TODO Auto-generated method stub
		return userDAO.isUsernameExsit(username);
	}
	
	@Override
	public User getUserByUsername(String username){
    	List<User> users = userDAO.getUserByUsername(username);
    	if(users!=null && !users.isEmpty()){
    		return users.get(0);
    	}else{
    		return null;
    	}
    }

	@Override
	public List<User> getAllTeacher() {
		// TODO Auto-generated method stub
		return userDAO.getUserListByRole(UserRole.TEACHER);
	}

	@Override
	public void addStudentForCourseByExcel(String savePath, MultipartFile file, Course course) {
		// TODO Auto-generated method stub
		try {
			// 文件上传
			String message = UploadDownloadFile.uploadfile(file, savePath);
			System.out.println(message);
			if (message.equals("NoFile")) {
			} else if (message.equals("error")) {
			} else {
				List<User> studentList = null;
				String path = savePath + "\\" + message;
				
				StudentExcel studentExcel = new StudentExcel();
				studentList = studentExcel.readStudentExcel(path);

				// 删除文件
				DeleteFile.deleteFile(path);
				
				for(User student:studentList){
					try{
						userDAO.addUser(student);
					}catch(Exception e){
						break;
					}
					courseDAO.addCourse(course);
					StudentCourse studentCourse = new StudentCourse();
					studentCourse.setCourse(course);
					studentCourse.setStudent(student);
					studentCourseDAO.addStudentCourse(studentCourse);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
