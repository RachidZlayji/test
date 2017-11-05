package com.expehris.springmvc.dao;

import java.util.List;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Employeur;;

public interface EmployeurDao {

	Employeur findById(int id);
	
	Employeur findByLogin(String sso);
	
	Employeur findByLoginPassword(String login,String password);

	
	void save(Employeur user);
	
	void deleteByLogin(String sso);
	
	List<Employeur> findAllEmployeurs();

}
