package com.cracker.dbservice;

import org.hibernate.Session;

import com.cracker.domain.UserCrk;
import com.cracker.util.HibernateUtil;

public class UserService  extends HibernateUtil{
	
	
	Session session;
	
	
	public UserService(){
		session = getSession();
	}

	
	public void saveUser(UserCrk user){
		try{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
	
	
	public void deleteUser(UserCrk user){
		try{
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
}
