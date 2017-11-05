package com.expehris.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expehris.springmvc.dao.EmployeurDao;
import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Employeur; 

@Service("employeurService")
@Transactional
public class EmployeurServiceImpl implements EmployeurService {
	
	@Autowired
	private EmployeurDao dao;

	public Employeur findById(int id) {
		return dao.findById(id);
	}

	public Employeur findByLogin(String sso) {
		return dao.findByLogin(sso);
	}
	
	public Employeur findByLoginPassword(String login,String password) {
		
		
		return dao.findByLoginPassword(login, password);
	}

	public void saveEmployeur(Employeur user) {

		dao.save(user);
	}

	public void updateEmployeur(Employeur user) {

		Employeur entity = dao.findById(user.getId_Employeur());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPrenom(user.getPrenom());
			entity.setNom(user.getNom());
			entity.setPasswd(user.getPasswd());
			entity.setPrenom(user.getPrenom());
			entity.setUserDocuments(user.getUserDocuments());
		}
		
	}

	public void deleteUserEmployeur(String sso) {
		dao.deleteByLogin(sso);
	}

	public List<Employeur> findAllEmployeurs() {
		
		return dao.findAllEmployeurs();
	}

	public boolean isUserLoginUnique(Integer id, String sso) {
		Employeur user = findByLogin(sso);
		return ( user == null || ((id != null) && (user.getId_Employeur() == id)));
	}

}
