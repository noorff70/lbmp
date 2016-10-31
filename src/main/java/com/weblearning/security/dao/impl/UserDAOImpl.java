package com.weblearning.security.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	

	/*
	 * (non-Javadoc)
	 * @see com.weblearning.security.dao.UserDAO#isValidUser(java.lang.String, java.lang.String)
	 * Returns the User if find based on name and password
	 * In- username, password,
	 * out- boolean
	 */
	@Override
	public boolean isValidUser(String username, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.like("username", username));
		List<User> result = cr.list();

		
		User user = (User) result.get(0);
		
		if (user.getPassword().equals(password))
			return true;
		
		return false;
	}

}
