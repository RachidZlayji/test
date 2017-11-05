package com.expehris.springmvc.dao;

import java.util.List;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByLogin(String login);
	User findByLoginPassword(String login,String password);

	
	void save(User user);
	
	void deleteByLogin(String login);
	
	List<User> findAllUsers();

	List<User> findAllByCreateur(String login);
	
	List<User>  findAllByEntreprise(String entreprise);
}

