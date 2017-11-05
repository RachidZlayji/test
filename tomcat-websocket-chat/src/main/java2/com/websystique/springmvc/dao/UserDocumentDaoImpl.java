package com.expehris.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.User;
import com.expehris.springmvc.model.UserDocument;
import com.expehris.springmvc.model.UserPayment;

@Repository("userDocumentDao")
public class UserDocumentDaoImpl extends AbstractDao<Integer, UserDocument> implements UserDocumentDao{

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<UserDocument>)crit.list();
	}

	public void save(UserDocument document) {
		persist(document);
	}

	
	public UserDocument findById(int id) {
		return getByKey(id);
	}
	
	public UserDocument findBulletin(String login, String annee, String mois, String typedocument) {
		Criteria userCriteria =  getSession().createCriteria(UserDocument.class,"user_document");
		userCriteria.add(Restrictions.eq("annee", annee));
		userCriteria.add(Restrictions.eq("mois", mois));
		userCriteria.add(Restrictions.eq("typedocument", typedocument));

		Criteria crit = userCriteria.createCriteria("user");
		crit.add(Restrictions.eq("login", login));
		
		List<UserDocument> list = (List<UserDocument>)userCriteria.list();
		if(list != null && list.size() >0) {
			return list.get(0);
		}
		return new UserDocument();
	}
	@SuppressWarnings("unchecked")
	public List<UserDocument> findAllByLogin(String login){
		Criteria crit = createEntityCriteria();
		Criteria userCriteria = crit.createCriteria("user");
		userCriteria.add(Restrictions.eq("login", login));
		return (List<UserDocument>)crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAllBulletin(String login, String annee, String typeDocument){
		List<UserDocument> listBulletin = new ArrayList<UserDocument>();
		UserDocument doc = findBulletin(login, annee, "Janvier", typeDocument);		
		doc.setMois("Janvier");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Février", typeDocument);		
		doc.setMois("Février");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Mars", typeDocument);		
		doc.setMois("Mars");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Avril", typeDocument);		
		doc.setMois("Avril");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Mai", typeDocument);		
		doc.setMois("Mai");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Juin", typeDocument);		
		doc.setMois("Juin");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Juillet", typeDocument);		
		doc.setMois("Juillet");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Aout", typeDocument);		
		doc.setMois("Aout");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Septembre", typeDocument);		
		doc.setMois("Septembre");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Octobre", typeDocument);		
		doc.setMois("Octobre");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Nouvembre", typeDocument);		
		doc.setMois("Nouvembre");
		listBulletin.add(doc);
		doc = findBulletin(login, annee, "Décembre", typeDocument);		
		doc.setMois("Décembre");
		listBulletin.add(doc);
		return listBulletin;
		
	}
	
	public List<UserDocument> findOtherDocuments(String login, String typedocument){

		Criteria userCriteria =  getSession().createCriteria(UserDocument.class,"user_document");
		userCriteria.add(Restrictions.eq("typedocument", typedocument));
		Criteria crit = userCriteria.createCriteria("user");
		crit.add(Restrictions.eq("login", login));
		return (List<UserDocument>)userCriteria.list();
	}
	
	/*public List<UserPayment> getBulletinForAllUsers(String annee,String entreprise,List<User> listuser){
		
		List<UserPayment> listpayment = new ArrayList();
		
		for(int i=0; i < listuser.size();i++) {
		User user = listuser.get(i);
		 UserPayment var = new UserPayment();
		 var.setNom(user.getLastName());
		 var.setPrenom(user.getFirstName());
		UserDocument doc = findBulletin(user.getLogin(),annee,"Janvier",) ;
			var.setMois1(doc.getId());
			
			
		
		
		}*/
		
		
		
		
	

	
	public void deleteById(int id) {
		UserDocument document =  getByKey(id);
		delete(document);
	}

}
