package com.easylearnjava.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easylearnjava.dto.User;
import com.easylearnjava.exception.DaoException;

@Repository
public class LoginDao {
	
	private final String GET_USER_PASSWORD_BY_USERNAME_HQL = "SELECT password  FROM User WHERE userName = :uName";
	private final String GET_PASSWORD_FROM_USER_BY_USERNAME_HQL = "from User as user where user.userName IN :uName";
	private final String GET_PASSWORD_FROM_USER_BY_USERNAME_SQL = "Select * from User where user_name=:uName";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getUserPassword(String usrName){

		Session session = null;
		String dbPassword = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery(GET_USER_PASSWORD_BY_USERNAME_HQL);
			query.setParameter("uName", usrName);
			dbPassword =  (String) query.uniqueResult();
			return dbPassword;
		}catch (Exception ex) {
			ex.printStackTrace();
			if(null!= session && session.isOpen()){
				session.close();
			}
			throw new DaoException();
		}	
	}
	
	//Just adding one more way of fetching the password
	public String getPasswordFromUserHQL(String usrName){

		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery(GET_PASSWORD_FROM_USER_BY_USERNAME_HQL);
			query.setParameter("uName", usrName);
			User user = (User)query.uniqueResult();
			if(null!= user){
				return user.getPassword();
			}else{
				return null;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			if(null!= session && session.isOpen()){
				session.close();
			}
			throw new DaoException();
		}	
	}
	
	//Just adding one more way of fetching the password
	public String getPasswordFromUserSQL(String usrName){

		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createSQLQuery(GET_PASSWORD_FROM_USER_BY_USERNAME_SQL).addEntity(User.class);
			query.setParameter("uName", usrName);
			User user = (User)query.uniqueResult();
			if(null!= user){
				return user.getPassword();
			}else{
				return null;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			if(null!= session && session.isOpen()){
				session.close();
			}
			throw new DaoException();
		}	
	}
	
}
