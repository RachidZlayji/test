package com.expehris.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.Admin;
 

@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao {

	public Admin findById(int id) {
		Admin user = getByKey(id);
		return user;
	}

	public Admin findByLogin(String sso) {
		System.out.println("SSO : "+sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		Admin user = (Admin)crit.uniqueResult();
		return user;
	}
	
	
	public Admin findByLoginPassword(String login,String password) {
		System.out.println("Login :  "+login +"Pass :  "+password);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("password", password));
		Admin user = (Admin)crit.uniqueResult();
		return user;

		
	}



	@SuppressWarnings("unchecked")
	public List<Admin> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Admin> users = (List<Admin>) criteria.list();
		
		return users;
	}
	public void save(Admin user) {
		persist(user);
	}

	public void deleteByLogin(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		Admin user = (Admin)crit.uniqueResult();
		delete(user);
	}

}
