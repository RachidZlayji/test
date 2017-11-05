package com.expehris.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import com.expehris.springmvc.model.User;
import com.expehris.springmvc.model.UserBulletin;
import com.expehris.springmvc.model.UserDocument;

public interface UserDocumentService {

	UserDocument findById(int id);

	List<UserDocument> findAll();
	
	List<UserDocument> findAllByLogin(String login);
	
	void saveDocument(UserDocument document);
	
	void deleteById(int id);
	
	public List<UserDocument> findAllBulletin(String login, String annee, String typeDocument);
	
	public List<UserDocument> findOtherDocuments(String login, String typedocument);
	

	public List<UserBulletin> findBulletinByYear(List <User>  listEmploye, String annee);
}
