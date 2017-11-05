package com.expehris.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expehris.springmvc.dao.ComptableDao;
import com.expehris.springmvc.model.Comptable;

@Service("comptableService")
@Transactional
public class ComptableServiceImpl implements ComptableService {
	
	@Autowired
	private ComptableDao dao;

	public Comptable findById(int id) {
		return dao.findById(id);
	}

	public Comptable findByLogin(String sso) {
		return dao.findByLogin(sso);
	}
	
	public Comptable findByLoginPassword(String login,String password) {
		
		return dao.findByLoginPassword(login, password);
	}

	
	public void saveComptable(Comptable user) {

		dao.save(user);
	}

	public void updateComptable(Comptable user) {

		Comptable entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPasswd(user.getPasswd());
			entity.setPrenom(user.getPrenom());
			entity.setNom(user.getNom());
			entity.setEntreprise( user.getEntreprise());
			entity.setUserDocuments(user.getUserDocuments());
		}
		
	}

	public void deleteUserComptable(String sso) {
		dao.deleteByLogin(sso);
	}

	public List<Comptable> findAllComptables() {
		
		return dao.findAllComptables();
	}

	public boolean isUserLoginUnique(Integer id, String sso) {
		Comptable user = findByLogin(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

}
