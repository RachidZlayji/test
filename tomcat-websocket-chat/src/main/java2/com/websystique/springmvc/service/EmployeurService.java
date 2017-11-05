package com.expehris.springmvc.service;

import java.util.List;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Employeur;

public interface EmployeurService {
	
	
	Employeur findById(int id);
	
	Employeur findByLogin(String sso);
	
	Employeur findByLoginPassword(String login,String password);

	
	void saveEmployeur(Employeur user);
	
	void updateEmployeur(Employeur user);
	
	void deleteUserEmployeur(String sso);

	List<Employeur> findAllEmployeurs(); 
	
	boolean isUserLoginUnique(Integer id, String sso);

}
