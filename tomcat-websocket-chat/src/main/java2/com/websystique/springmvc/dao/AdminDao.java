package com.expehris.springmvc.dao;

import java.util.List;

import com.expehris.springmvc.model.Admin;

public interface AdminDao {

	Admin findById(int id);
	
	Admin findByLogin(String login);
	Admin findByLoginPassword(String login,String password);
	
	void save(Admin user);
	
	void deleteByLogin(String login);
	
	List<Admin> findAllUsers();
}

