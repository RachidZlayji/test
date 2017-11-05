package com.expehris.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Employeur;;




@Repository("EmployeurDao")
public class EmployeurDaoImpl extends AbstractDao<Integer, Employeur> implements EmployeurDao {

	public Employeur findById(int id) {
		Employeur employeur = getByKey(id);
		return employeur;
	}

	public Employeur findByLogin(String login) {
		System.out.println("Login : "+login);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		Employeur employeur = (Employeur)crit.uniqueResult();
		return employeur;
	}

	public Employeur findByLoginPassword(String login,String password) {
		System.out.println("Login :  "+login +"Pass :  "+password);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("passwd", password));
		Employeur user = (Employeur)crit.uniqueResult();
		return user;

		
	}
	
	
	
	
	public void save(Employeur user) {
			persist(user);	
			System.out.println(" **************entreprise  "+user.getEntreprise());
			System.out.println(" *******************Nom  "+user.getNom());

	}

	public void deleteByLogin(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", sso));
		Employeur user = (Employeur)crit.uniqueResult();
		delete(user);
	}
	@SuppressWarnings("unchecked")
	public List<Employeur> findAllEmployeurs() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nom"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Employeur> users = (List<Employeur>) criteria.list();
		
		return users;
	}

}
