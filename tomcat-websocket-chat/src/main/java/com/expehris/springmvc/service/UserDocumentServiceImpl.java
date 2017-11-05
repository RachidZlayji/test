package com.expehris.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expehris.springmvc.dao.UserDocumentDao;
import com.expehris.springmvc.model.User;
import com.expehris.springmvc.model.UserBulletin;
import com.expehris.springmvc.model.UserDocument;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService{

	@Autowired
	UserDocumentDao dao;

	public UserDocument findById(int id) {
		return dao.findById(id);
	}

	public List<UserDocument> findAll() {
		return dao.findAll();
	}

	public List<UserDocument> findAllByLogin(String login) {
		return dao.findAllByLogin(login);
	}
	
	public void saveDocument(UserDocument document){
		dao.save(document);
	}

	public void deleteById(int id){
		dao.deleteById(id);
	}
	
	public List<UserDocument> findAllBulletin(String login, String annee, String typeDocument){
		return dao.findAllBulletin(login, annee, typeDocument);
	}
	
	public List<UserDocument> findOtherDocuments(String login, String typedocument){
		return dao.findOtherDocuments(login, typedocument);
	}
	public 	List<UserBulletin> findBulletinByYear(List <User>  listEmploye, String annee){
		return dao.findBulletinByYear(listEmploye, annee);
	}
}
