package com.egovorushkin.onlinepolyclinicapp.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egovorushkin.onlinepolyclinicapp.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String userName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", userName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user
		currentSession.saveOrUpdate(theUser);

	}

}
