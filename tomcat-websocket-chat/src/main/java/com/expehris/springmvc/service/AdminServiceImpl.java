package com.expehris.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expehris.springmvc.dao.AdminDao;
import com.expehris.springmvc.model.Admin;


@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao dao;

	public Admin findById(int id) {
		return dao.findById(id);
	}

	public Admin findByLogin(String sso) {
		Admin user = dao.findByLogin(sso);
		return user;
	}

	public Admin findByLoginPassword(String login,String password) {
		
		Admin user = dao.findByLoginPassword(login, password);
		return user;
	}

	
	public void saveUser(Admin user) {
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(Admin user) {
		Admin entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPassword(user.getPassword());
		}
	}

	
	public void deleteUserByLogin(String sso) {
		dao.deleteByLogin(sso);
	}

	public List<Admin> findAllUsers() {
		return dao.findAllUsers();
	}
	
	public boolean isUserSSOUnique(Integer id, String sso) {
		Admin user = findByLogin(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
