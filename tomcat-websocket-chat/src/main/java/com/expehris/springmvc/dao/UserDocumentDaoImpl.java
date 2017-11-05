package com.expehris.springmvc.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.User;
import com.expehris.springmvc.model.UserBulletin;
import com.expehris.springmvc.model.UserDocument;

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
	
	public void deleteById(int id) {
		UserDocument document =  getByKey(id);
		delete(document);
	}


	
	public List<UserBulletin> findBulletinByYear(List <User>  listEmploye, String annee){
		List<UserBulletin> listBulletin = new ArrayList<UserBulletin>();
		for(User user: listEmploye) {
			UserBulletin userBull = new UserBulletin();
			userBull.setNom(user.getLastName());
			userBull.setPrenom(user.getFirstName());
			userBull.setLogin(user.getLogin());
			List<UserDocument> docs = findAllBulletin(user.getLogin(), annee, "Bulletin de paie");
			System.out.println("Test doc"+(docs!=null && docs.size()>0 &&docs.get(0) !=null? docs.get(0) :""));
			userBull.setMois1(docs!=null && docs.size()>0 &&docs.get(0) !=null && docs.get(0).getId()>0 ? ""+docs.get(0).getId() :"");
			userBull.setMois2(docs!=null && docs.size()>1 &&docs.get(1) !=null && docs.get(1).getId()>0 ? ""+docs.get(1).getId() :"");
			userBull.setMois3(docs!=null && docs.size()>2 &&docs.get(2) !=null && docs.get(2).getId()>0 ? ""+docs.get(2).getId() :"");
			userBull.setMois4(docs!=null && docs.size()>3 &&docs.get(3) !=null && docs.get(3).getId()>0 ? ""+docs.get(3).getId() :"");
			userBull.setMois5(docs!=null && docs.size()>4 &&docs.get(4) !=null && docs.get(4).getId()>0 ? ""+docs.get(4).getId() :"");
			userBull.setMois6(docs!=null && docs.size()>5 &&docs.get(5) !=null && docs.get(5).getId()>0 ? ""+docs.get(5).getId() :"");
			userBull.setMois7(docs!=null && docs.size()>6 &&docs.get(6) !=null && docs.get(6).getId()>0 ? ""+docs.get(6).getId() :"");
			userBull.setMois8(docs!=null && docs.size()>7 &&docs.get(7) !=null && docs.get(7).getId()>0 ? ""+docs.get(7).getId() :"");
			userBull.setMois9(docs!=null && docs.size()>8 &&docs.get(8) !=null && docs.get(8).getId()>0 ? ""+docs.get(8).getId() :"");
			userBull.setMois10(docs!=null && docs.size()>9 &&docs.get(9) !=null && docs.get(9).getId()>0 ? ""+docs.get(9).getId() :"");
			userBull.setMois11(docs!=null && docs.size()>10 &&docs.get(10) !=null && docs.get(10).getId()>0 ? ""+docs.get(10).getId() :"");
			userBull.setMois12(docs!=null && docs.size()>11 &&docs.get(11) !=null && docs.get(11).getId()>0 ? ""+docs.get(11).getId() :"");	
			listBulletin.add(userBull);
		}
		return listBulletin;
	}
}
