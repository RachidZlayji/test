package com.expehris.springmvc.service;

import java.util.List;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findByLogin(String sso);
	
	User findByLoginPassword(String login,String password);

	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByLogin(String sso);

	List<User> findAllUsers(); 
	
	List<User> findAllByCreateur(String login);
	List<User> findAllByEntreprise(String entreprise);
	
	boolean isUserSSOUnique(Integer id, String sso);
	
	
}