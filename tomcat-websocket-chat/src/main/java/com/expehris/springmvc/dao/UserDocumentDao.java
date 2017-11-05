package com.expehris.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import com.expehris.springmvc.model.UserBulletin;
import com.expehris.springmvc.model.UserDocument;
import com.expehris.springmvc.model.User;

public interface UserDocumentDao {

	List<UserDocument> findAll();
	
	UserDocument findById(int id);
	
	void save(UserDocument document);
	
	List<UserDocument> findAllByLogin(String login);
	
	void deleteById(int id);
	
	UserDocument findBulletin(String login, String annee, String mois, String typeDocument);
	
	List<UserDocument> findAllBulletin(String login, String annee, String typeDocument);
	
	List<UserDocument> findOtherDocuments(String login, String typeDocument);
	

	List<UserBulletin> findBulletinByYear(List <User>  listEmploye, String annee);
	
}
