package com.expehris.springmvc.service;

import java.util.List;

import com.expehris.springmvc.model.Admin;


public interface AdminService {
	
	Admin findById(int id);
	
	Admin findByLogin(String sso);
	Admin findByLoginPassword(String login,String password);

	
	void saveUser(Admin user);
	
	void updateUser(Admin user);
	
	void deleteUserByLogin(String sso);

	List<Admin> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);
	
	
}