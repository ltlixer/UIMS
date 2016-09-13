package com.lixer.uims.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lixer.uims.dao.UserDAO;
import com.lixer.uims.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUser(String username, String password){
		Query q= sessionFactory.getCurrentSession().createQuery("From User u Where u.username=:username and u.password=:password");
		q.setString("username", username);
		q.setString("password", password);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		return userList;
	}
	
	@Override
	public List<User> getUserByUsername(String username){
		Query q= sessionFactory.getCurrentSession().createQuery("From User u Where u.username=:username");
		q.setString("username", username);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		return userList;
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().flush(); 
	}

	@Override
	public boolean isUsernameExsit(String username) {
		Query q= sessionFactory.getCurrentSession().createQuery("From User u Where u.username=:username");
		q.setString("username", username);
		return q.list()!=null?(!q.list().isEmpty()):false;
	}

	@Override
	public boolean deleteUserByUsername(String username) {
		Query q= sessionFactory.getCurrentSession().createQuery("From User u Where u.username=:username");
		q.setString("username", username);
		User user = (User)q.list().get(0);
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public List<User> getUserListByRole(String role) {
		// TODO Auto-generated method stub
		Query q= sessionFactory.getCurrentSession().createQuery("From User u Where u.role=:role");
		q.setString("role", role);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		return userList;
	}
	
}
