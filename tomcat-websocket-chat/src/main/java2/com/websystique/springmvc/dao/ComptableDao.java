package com.expehris.springmvc.dao;

import java.util.List;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Comptable;

public interface ComptableDao {
	
Comptable findById(int id);
	
Comptable findByLogin(String sso);

Comptable findByLoginPassword(String login,String password);



	
	void save(Comptable user);
	
	void deleteByLogin(String sso);
	
	List<Comptable> findAllComptables();


}
