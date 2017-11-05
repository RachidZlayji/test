package com.expehris.springmvc.service;

import java.util.List;

import com.expehris.springmvc.model.Comptable;

public interface ComptableService {
	
	
	Comptable findById(int id);
	
	Comptable findByLogin(String sso);
	
	Comptable findByLoginPassword(String login,String password);

	
	void saveComptable(Comptable user);
	
	void updateComptable(Comptable user);
	
	void deleteUserComptable(String sso);

	List<Comptable> findAllComptables(); 
	
	boolean isUserLoginUnique(Integer id, String sso);

}
