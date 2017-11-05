package com.expehris.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expehris.springmvc.dao.UserDao;
import com.expehris.springmvc.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByLogin(String sso) {
		User user = dao.findByLogin(sso);
		return user;
	}
	
	public User findByLoginPassword(String login,String password) {
		
		User user = dao.findByLoginPassword(login, password);
		return user;		
	}

	

	public void saveUser(User user) {
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setPassword(user.getPassword());
			entity.setEntreprise(user.getEntreprise());
			entity.setUserDocuments(user.getUserDocuments());
		}
	}

	
	public void deleteUserByLogin(String sso) {
		dao.deleteByLogin(sso);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	
	public List<User> findAllByCreateur(String login){
		
		return dao.findAllByCreateur(login);
	}

	public  List<User> findAllByEntreprise(String entreprise){
		return dao.findAllByEntreprise(entreprise);
	}
	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findByLogin(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
