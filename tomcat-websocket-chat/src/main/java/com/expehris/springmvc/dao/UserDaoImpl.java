package com.expehris.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.User;



@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		User user = getByKey(id);
		return user;
	}

	public User findByLogin(String sso) {
		System.out.println("SSO : "+sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		User user = (User)crit.uniqueResult();
		return user;
	}
	
	
	public User findByLoginPassword(String login,String password) {
		System.out.println("Login :  "+login +"Pass :  "+password);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("password", password));
		User user = (User)crit.uniqueResult();
		return user;

		
	}
	

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		return users;
	}
	public List<User> findAllByCreateur(String login){
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.add(Restrictions.eq("createur", login));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		return users;
	}
	public List<User>  findAllByEntreprise(String entreprise){
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.add(Restrictions.eq("entreprise", entreprise));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		return users;
		
	}
	public void save(User user) {
		persist(user);
	}

	public void deleteByLogin(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		User user = (User)crit.uniqueResult();
		delete(user);
	}

}
