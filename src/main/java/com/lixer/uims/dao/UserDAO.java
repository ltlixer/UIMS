package com.lixer.uims.dao;

import java.util.List;

import com.lixer.uims.entity.User;

public interface UserDAO {
	
	/**
	 * 根据用户名和密码获取用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public List<User> getUser(String username, String password);
	
	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	public List<User> getUserByUsername(String username);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public void addUser(User user);
	
	/**
	 * 判断用户名在数据库中是否存在
	 * @param username
	 * @return
	 */
	public boolean isUsernameExsit(String username);
	
	/**
	 * 根据用户名删除用户
	 * @param username
	 * @return
	 */
	public boolean deleteUserByUsername(String username);
	
	/**
	 * 获取某一角色的所有用户
	 * @param role
	 * @return
	 */
	public List<User> getUserListByRole(String role);

}
