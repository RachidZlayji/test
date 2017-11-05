package com.expehris.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Comptable;




@Repository("ComptableDao")
public class ComptableDaoImpl extends AbstractDao<Integer, Comptable> implements ComptableDao {

	public Comptable findById(int id) {
		Comptable comptable = getByKey(id);
		return comptable;
	}

	public Comptable findByLogin(String login) {
		System.out.println("Login : "+login);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		Comptable comptable = (Comptable)crit.uniqueResult();
		return comptable;
	}
	public Comptable findByLoginPassword(String login,String password) {
		System.out.println("Login :  "+login +"Pass :  "+password);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("passwd", password));
		Comptable user = (Comptable)crit.uniqueResult();
		return user;

		
	}
	

	public void save(Comptable user) {
			persist(user);		
	}

	public void deleteByLogin(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		Comptable user = (Comptable)crit.uniqueResult();
		delete(user);
	}
	@SuppressWarnings("unchecked")
	public List<Comptable> findAllComptables() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nom"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Comptable> users = (List<Comptable>) criteria.list();
		
		return users;
	}

}
